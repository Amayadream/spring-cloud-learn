package com.amayadream.provider.web.controller;

import com.amayadream.provider.core.model.User;
import com.amayadream.provider.core.repository.UserRepository;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xjding
 * @date :   2017-11-29 19:54
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserRepository userRepository;
    @Resource
    private EurekaDiscoveryClient discoveryClient;


    @RequestMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(value = "/instance-info")
    public ServiceInstance showInfo() {
        return this.discoveryClient.getLocalServiceInstance();
    }

}
