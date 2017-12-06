package com.amayadream.feign.web.controller;

import com.amayadream.feign.core.model.User;
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
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://application1/user/" + id, User.class);
    }

}
