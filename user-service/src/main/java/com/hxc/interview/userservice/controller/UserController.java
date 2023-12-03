package com.hxc.interview.userservice.controller;


import com.hxc.interView.anno.CheckParam;
import com.hxc.interView.entity.User;
import com.hxc.interView.result.ServiceResult;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserByCondition")
    public ServiceResult getUserByCondition(@RequestBody User user) {
        return userService.getUserByCondition(user);
    }

    @PostMapping("/addUser")
    public ServiceResult addUser(@RequestBody @CheckParam User user) {
        return userService.addUser(user);
    }

}
