package com.amayadream.consumer.web.controller;

import com.amayadream.consumer.core.client.UserServiceClient;
import com.amayadream.consumer.core.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : xjding
 * @date :   2017-11-30 14:31
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserServiceClient userServiceClient;

    @RequestMapping(value = "/{id}")
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(@PathVariable Long id) {
        return this.userServiceClient.findById(id);
    }

    public User fallback(Long id) {
        log.info("异常发生, 进入fallback方法, id: {}", id);
        User user = User.builder()
                .id(-1L)
                .userName("default user")
                .age(0)
                .build();
        return user;
    }

}
