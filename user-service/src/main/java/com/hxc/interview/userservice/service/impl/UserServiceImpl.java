package com.hxc.interview.userservice.service.impl;

import com.hxc.interView.entity.User;
import com.hxc.interView.result.ServiceResult;
import com.hxc.interView.util.CommonUtil;
import com.hxc.interview.userservice.dao.UserMapper;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ServiceResult addUser(User user) throws IllegalAccessException {
        //先判断username是否重复
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", user.getUserName());
        map.put("idNo", user.getIdNo());
        map.put("email", user.getEmail());
        List<User> existUsers = userMapper.getUserByConditionForInsert(map);
        if (null == existUsers || existUsers.size() == 0) {
            //不存在重复信息
            userMapper.addUser(user);
            return ServiceResult.success(200, "success", null);
        } else {
            //存在重复信息， 把重复的信息封装到map中返回
            HashMap<String, Object> userMapParam = (HashMap<String, Object>) CommonUtil.objectToMap(user);
            HashMap<String, Object> userMapResult = (HashMap<String, Object>) CommonUtil.objectToMap(existUsers.get(0));
            userMapResult.forEach((k,v) -> {
                if (v.equals(userMapParam.get(k))) {

                } else {
                    userMapParam.put(k, "");
                }
            });
            return ServiceResult.error(400, "success", userMapParam);
        }


    }
}
