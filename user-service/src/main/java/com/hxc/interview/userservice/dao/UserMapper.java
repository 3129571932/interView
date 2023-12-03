package com.hxc.interview.userservice.dao;

import com.hxc.interView.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserByCondition(User user);

}
