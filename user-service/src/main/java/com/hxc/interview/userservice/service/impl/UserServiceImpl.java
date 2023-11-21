package com.hxc.interview.userservice.service.impl;

import com.hxc.interview.commonservice.entity.User;
import com.hxc.interview.commonservice.result.ServiceResult;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public ServiceResult getUserByCondition(User user) {
        return ServiceResult.success(200, "success", null);
    }
}
