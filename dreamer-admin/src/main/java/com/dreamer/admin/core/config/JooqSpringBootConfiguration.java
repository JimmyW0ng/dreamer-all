package com.dreamer.admin.core.config;

import com.zaxxer.hikari.HikariDataSource;
import com.dreamer.admin.core.exception.*;
import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.ExecuteListenerProvider;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.conf.SettingsTools;
import org.jooq.conf.StatementType;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * jooq配置
 */
@Configuration
public class JooqSpringBootConfiguration {

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driverClassName}")
    private String dataSourceClassName;

    @Value("${spring.datasource.hikari.idleTimeout}")
    private int connectionTimeout;

    @Value("${spring.datasource.hikari.maximumPoolSize}")
    private int maxLifetime;

    @Autowired
    private Environment env;

    @Bean("dataSource")
    @Primary
    public DataSource primaryDataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(maxLifetime);
        ds.setDriverClassName(dataSourceClassName);
        ds.setJdbcUrl(dataSourceUrl);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setIdleTimeout(600000);
        return ds;
    }

    @Bean
    @DependsOn("dataSource")
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @DependsOn("dataSource")
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public ExceptionTranslator exceptionTranslator() {
        return new ExceptionTranslator();
    }

    @Bean
    public ExecuteListenerProvider executeListenerProvider(ExceptionTranslator exceptionTranslator) {
        return new DefaultExecuteListenerProvider(exceptionTranslator);
    }

    @Bean
    public org.jooq.Configuration jooqConfig(@Autowired ConnectionProvider connectionProvider, @Autowired
            ExecuteListenerProvider executeListenerProvider) {
        Settings settings = SettingsTools.defaultSettings();
        settings.setStatementType(StatementType.PREPARED_STATEMENT);
        settings.withRenderSchema(false);
        org.jooq.Configuration derive = new DefaultConfiguration()
                .derive(connectionProvider)
                .derive(settings)
                .derive(executeListenerProvider)
                .derive(SQLDialect.MYSQL)
                .set(DefaultExecuteListenerProvider.providers(new SlowQueryListener()));

        return derive;
    }

    @Bean
    public DSLContext dsl(org.jooq.Configuration config) {
        return new DefaultDSLContext(config);
    }

}
