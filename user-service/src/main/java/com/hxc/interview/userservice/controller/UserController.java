package com.hxc.interview.userservice.controller;

import com.hxc.interview.commonservice.entity.User;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByCondition")
    public Object getUserByCondition(@RequestBody User user) {
        return userService.getUserByCondition(user);
    }

}
