package com.dreamer.admin.config;

import com.dreamer.admin.core.HttpMsgConverter.WeChatHttpMsgConverter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JW on 17/9/4.
 */
@Configuration
public class RestTempldateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.getMessageConverters().add(new WeChatHttpMsgConverter());
        return restTemplate;
    }

}
