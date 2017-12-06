package com.amayadream.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author :  Amayadream
 * @date :  2017.12.06 21:21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FeignApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
