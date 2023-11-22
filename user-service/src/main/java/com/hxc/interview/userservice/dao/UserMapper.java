package com.hxc.interview.userservice.dao;

import com.hxc.interview.commonservice.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select(
            "select * from user" +
            "where id = #{param.id}" +
            "" +
            "and name = #{param.name}"
    )
    List<User> getUserByCondition(@Param("param") User user);

}
