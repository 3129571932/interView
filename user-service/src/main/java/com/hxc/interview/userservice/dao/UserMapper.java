package com.hxc.interview.userservice.dao;

import com.hxc.interView.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<User> getUserByCondition(User user);

    List<User> getUserByConditionForInsert(Map<String, Object> map);

    void addUser(User user);

    int updateUser(Map<String, Object> map);

}
