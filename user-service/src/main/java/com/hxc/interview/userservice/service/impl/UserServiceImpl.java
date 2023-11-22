package com.hxc.interview.userservice.service.impl;

import com.hxc.interview.commonservice.entity.User;
import com.hxc.interview.commonservice.result.ServiceResult;
import com.hxc.interview.userservice.dao.UserMapper;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public ServiceResult getUserByCondition(User user) {
        List<User> users = userMapper.getUserByCondition(user);
        return ServiceResult.success(200, "success", users);
    }

    @Override
    public ServiceResult addUser(User user) {
        return null;
    }
}
