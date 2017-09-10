package com.dreamer.admin.config;

import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by JW on 17/8/20.
 */
@Configuration
@Import({MessageSourceAutoConfiguration.class})
public class SpringMessageConfig {
}
