package com.jankin.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * web-springboot 启动
 *
 * @author 刘洋印
 * @date 2018/3/28 17:16
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.jankin"})
public class WebBootApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebBootApplication.class, args);
    }
}
