package com.amayadream.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : xjding
 * @date :   2017-11-29 10:23
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EurekaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
