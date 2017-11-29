package com.amayadream.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : xjding
 * @date :   2017-11-29 12:32
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class ConfigApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ConfigApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
