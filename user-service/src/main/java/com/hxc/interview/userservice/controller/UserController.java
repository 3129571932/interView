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
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserByCondition")
    public ServiceResult getUserByCondition(@RequestBody User user) {
        return userService.getUserByCondition(user);
    }

    @PostMapping("/addUser")
    public ServiceResult addUser(@RequestBody @CheckParam(rule = "userName=NOTNULL,gender=NOTNULL,idNo=NOTNULL,idNo=ID_REG,phone=NOTNULL,phone=PHONE_REG,password=NOTNULL,key=NOTNULL,iv=NOTNULL,email=NOTNULL,email=EMAIL_REG") User user) throws IllegalAccessException {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public ServiceResult login(@RequestBody @CheckParam(rule = "email=NOTNULL,email=EMAIL_REG,password=NOTNULL,key=NOTNULL,iv=NOTNULL") User user) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        return userService.login(user);
    }

}
