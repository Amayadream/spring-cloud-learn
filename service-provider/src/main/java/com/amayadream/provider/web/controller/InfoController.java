package com.amayadream.provider.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xjding
 * @date :   2017-11-30 09:48
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "/info")
public class InfoController {

    @Value("${application.environment}")
    private String environment;

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @RequestMapping(value = "/instance-info")
    public ServiceInstance showInfo() {
        return this.discoveryClient.getLocalServiceInstance();
    }

    @RequestMapping(value = "/env")
    public String showProfile() {
        return environment;
    }

}
