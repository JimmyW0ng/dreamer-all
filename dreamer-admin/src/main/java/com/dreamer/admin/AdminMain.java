package com.dreamer.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 后台管理入口
 * Created by J.W on 2017/8/8 0008.
 */
@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = {"com.dreamer.business", "com.dreamer.admin", "com.dreamer.common"})
public class AdminMain {

    public static void main(String[] args) {
        SpringApplication.run(AdminMain.class, args);
    }

}
