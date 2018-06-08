package com.amayadream.provider.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Amayadream
 * @date :   2018-06-08 16:12
 */
@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "/echo")
public class EchoController {

    @RequestMapping(value = "/{message}")
    public String echo(@PathVariable String message) {
        return message;
    }

}
