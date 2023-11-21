package com.hxc.interview.userservice.service;

import com.hxc.interview.commonservice.entity.User;
import com.hxc.interview.commonservice.result.ServiceResult;

public interface UserService {

    ServiceResult getUserByCondition(User user);

}
