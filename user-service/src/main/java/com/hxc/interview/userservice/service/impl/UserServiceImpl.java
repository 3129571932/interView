package com.hxc.interview.userservice.service.impl;

import com.hxc.interview.commonservice.entity.User;
import com.hxc.interview.commonservice.result.ServiceResult;
import com.hxc.interview.userservice.dao.UserMapper;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServiceResult getUserByCondition(User user) {
        userMapper.getUserByCondition(user);
        return ServiceResult.success(200, "success", null);
    }
}
