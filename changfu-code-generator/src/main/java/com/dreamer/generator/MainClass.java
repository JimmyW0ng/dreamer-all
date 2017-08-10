package com.dreamer.generator;

import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy on 2016/12/8.
 */
public class MainClass {
    public static String EXCLUDES = "QRTZ_FIRED_TRIGGERS|QRTZ_PAUSED_TRIGGER_GRPS|QRTZ_SCHEDULER_STATE|QRTZ_LOCKS" +
            "|QRTZ_SIMPLE_TRIGGERS|QRTZ_SIMPROP_TRIGGERS|QRTZ_CRON_TRIGGERS|QRTZ_CRON_TRIGGERS|QRTZ_TRIGGERS" +
            "|QRTZ_JOB_DETAILS|QRTZ_CALENDARS|QRTZ_BLOB_TRIGGERS";

    public void codeGgenerator() throws Exception {
        List list = new ArrayList();
        Schema schema = new Schema();
        schema.setInputSchema("jw");
        list.add(schema);
        schema = new Schema();
        schema.setOutputSchemaToDefault(true);
        list.add(schema);

        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("com.mysql.jdbc.Driver")
                        .withUrl("jdbc:mysql://127.0.0.1:3306/jw?useUnicode=true&amp;" +
                                "characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull&amp;autoReconnect=true")
                        .withUser("root")
                        .withPassword("root"))
                .withGenerator(new Generator()
                        .withDatabase(new Database()
                                // .withRecordTimestampFields("create_at")
                                .withRecordVersionFields("version").withDateAsTimestamp(true)
                                //.withForcedTypes(new ForcedType().withExpression("is_*").withName("BOOLEAN"))

                                .withName("org.jooq.util.mysql.MySQLDatabase")
                                .withIncludes(".*")
                                .withExcludes(EXCLUDES)
                                .withSchemata(list))
                        .withStrategy(new Strategy().withName("com.dreamer.generator.CustomGenertor"))
                        .withGenerate(new Generate().withFluentSetters(true)
                                                    .withPojos(true).withDaos(true))
                        .withTarget(new Target()
                                .withPackageName("com.dreamer.domain")
                                .withDirectory("dreamer-domain/src/main/java")));

        GenerationTool.generate(configuration);

    }

    public static void main(String[] args) throws Exception {
        MainClass mainClass = new MainClass();
        mainClass.codeGgenerator();
    }
}