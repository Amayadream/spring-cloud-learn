package com.amayadream.provider.web.controller;

import com.amayadream.provider.core.model.User;
import com.amayadream.provider.core.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : xjding
 * @date :   2017-11-29 19:54
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @RequestMapping(value = "/find")
    public List<User> find(String userName, Integer age) {
        List<User> users = userRepository.findAll((root, query, builder) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(userName)) {
                list.add(builder.like(root.get("userName").as(String.class), "%".concat(userName).concat("%")));
            }
            if (!StringUtils.isEmpty(age)) {
                list.add(builder.equal(root.get("age").as(Integer.class), age));
            }
            Predicate[] p = new Predicate[list.size()];
            return builder.and(list.toArray(p));
        });
        return users;
    }


}
