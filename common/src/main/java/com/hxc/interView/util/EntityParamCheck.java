package com.hxc.interView.util;

import com.hxc.interView.entity.User;

import java.util.HashMap;

import static com.hxc.interView.util.CommonUtil.objectToMap;
import static com.hxc.interView.util.CommonUtil.stringToMap;

public class EntityParamCheck {

    public static boolean checkUser(User user, String rule) throws IllegalAccessException {
        if(null == user)
            return false;
        HashMap<String, String> ruleMap = stringToMap(rule);
        HashMap<String, Object> objMap = (HashMap<String, Object>) objectToMap(user);
        ruleMap.forEach((k, v) -> {

        });
        return false;
    }



}
