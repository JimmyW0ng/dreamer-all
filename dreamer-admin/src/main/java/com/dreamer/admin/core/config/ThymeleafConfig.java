package com.dreamer.admin.core.config;

import com.dreamer.admin.core.dialect.MyDialect;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

/**
 * Created by jw on 2016/12/13.
 */
@Configuration
@Import({ThymeleafAutoConfiguration.class})
public class ThymeleafConfig {
    @Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }

    @Bean
    public MyDialect myDialect() {
        return new MyDialect();
    }
}
