package com.amayadream.consumer.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : xjding
 * @date :   2018-06-08 16:15
 */
@Slf4j
@RestController
@RequestMapping(value = "/sample")
public class SampleController {

    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = "/{message}")
    public String echo(@PathVariable String message) {
        return this.restTemplate.getForObject("http://application1/echo/" + message, String.class);
    }

    public String fallback(String message) {
        log.warn("异常发生, 进入fallback方法, message: {}", message);
        return "Service Error";
    }

}
