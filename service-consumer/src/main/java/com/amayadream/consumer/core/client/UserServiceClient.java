package com.amayadream.consumer.core.client;

import com.amayadream.consumer.core.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author :  Amayadream
 * @date :  2017.12.06 21:23
 */
@Component
@FeignClient(value = "/user")
public interface UserServiceClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    User findById(@PathVariable Long id);

}
