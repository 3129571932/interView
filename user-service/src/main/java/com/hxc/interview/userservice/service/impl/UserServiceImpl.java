package com.hxc.interview.userservice.service.impl;

import com.hxc.interView.entity.User;
import com.hxc.interView.result.ServiceResult;
import com.hxc.interView.util.CommonUtil;
import com.hxc.interview.userservice.dao.UserMapper;
import com.hxc.interview.userservice.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
    public ServiceResult addUser(User user) throws IllegalAccessException {
        //先判断username是否重复
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", user.getUserName());
        map.put("idNo", user.getIdNo());
        map.put("email", user.getEmail());
        List<User> existUsers = userMapper.getUserByConditionForInsert(map);
        if (null == existUsers || existUsers.size() == 0) {
            //不存在重复信息
            user.setRegisterDate(new Date());
            userMapper.addUser(user);
            return ServiceResult.success(200, "success", null);
        } else {
            //存在重复信息， 把重复的信息封装到map中返回
            HashMap<String, Object> userMapParam = (HashMap<String, Object>) CommonUtil.objectToMap(user);
            HashMap<String, Object> userMapResult = (HashMap<String, Object>) CommonUtil.objectToMap(existUsers.get(0));
            userMapResult.forEach((k,v) -> {
                if (!v.equals(userMapParam.get(k))) {
                    userMapParam.put(k, "");
                }
            });
            return ServiceResult.error(400, "用户重复", userMapParam);
        }


    }

    @Override
    public ServiceResult login(User user) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        User userParam = new User();
        userParam.setEmail(user.getEmail());
        List<User> userByConditionRes = userMapper.getUserByCondition(userParam);
        if (null != userByConditionRes && userByConditionRes.size() == 1) {
            boolean pwdTrueFlag;
            //有且仅有一个被查询到 进行密码校验
            try {
                byte[] inputPassword = CommonUtil.decryptCBC(CommonUtil.parseHexStr2Byte(user.getPassword()), user.getKey().getBytes(), user.getIv().getBytes());
                byte[] userPassword = CommonUtil.decryptCBC(CommonUtil.parseHexStr2Byte(userByConditionRes.get(0).getPassword()), userByConditionRes.get(0).getKey().getBytes(), userByConditionRes.get(0).getIv().getBytes());
                pwdTrueFlag = new String(inputPassword, "UTF-8").equals(new String(userPassword, "UTF-8"));
            }catch (NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | InvalidKeyException | UnsupportedEncodingException exception) {
                //日志记录
                return ServiceResult.error(500, "密码解密错误", null);
            }
            HashMap<String, Object> paramMap = new HashMap<>();
            paramMap.put("id", userByConditionRes.get(0).getId());
            //密码错误次数
            Integer loginPwdErrorTimes = userByConditionRes.get(0).getLogin_pwd_error_times();
            //用户状态
            Integer status = userByConditionRes.get(0).getUserStatus();
            Integer code = -1;
            boolean isSuccess = false;
            String msg = "";
            Object obj = new Object();
            if (!pwdTrueFlag) {
                //密码错误 密码错误次数+1，并判断是否到达3次，到达3次用户状态改成封禁状态
                paramMap.put("login_pwd_error_times", loginPwdErrorTimes.equals(3) ? 3 : loginPwdErrorTimes + 1);
                status = status.equals(0) ? 0 : (paramMap.get("login_pwd_error_times").equals(3) ? 0 : 1);
                paramMap.put("userStatus", status);
                msg = "用户密码错误";
                code = 400;
                isSuccess = false;
                obj = null;
            } else {
                //密码正确，判断用户状态和密码错误次数
                if (status.equals(1) && loginPwdErrorTimes < 3) {
                    //判断登陆成功 清空密码错误次数
                    paramMap.put("userStatus", 1);
                    paramMap.put("login_pwd_error_times", 0);
                    isSuccess = true;
                    code = 200;
                    msg = "登陆成功";
                    obj = userByConditionRes.get(0);
                } else {
                    paramMap.put("userStatus", 0);
                    paramMap.put("login_pwd_error_times", loginPwdErrorTimes.equals(3) ? 3 : loginPwdErrorTimes + 1);
                    msg = status.equals(0) ? "用户状态为封禁状态" : "用户密码错误次数超过3次，被封禁！";
                    obj = user;
                    code = 200;
                    isSuccess = false;
                }
            }
            int row = userMapper.updateUser(paramMap);
            if (row != 1) {
                //更新失败，记录日志
            }
            return isSuccess ? ServiceResult.success(code, msg, obj) : ServiceResult.error(code, msg, obj);
        } else {
            //没有找到或者有多个用户,都报错没有该用户
            return ServiceResult.error(400, "未找到该用户", user);
        }
    }
}
