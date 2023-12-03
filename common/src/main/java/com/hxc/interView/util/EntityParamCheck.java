package com.hxc.interView.util;

import com.hxc.interView.entity.User;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import static com.hxc.interView.util.CommonUtil.objectToMap;
import static com.hxc.interView.util.CommonUtil.stringToMap;

public class EntityParamCheck {

    public static boolean checkUser(User user, String rule) throws IllegalAccessException {
        if(null == user)
            return false;
        HashMap<String, String> ruleMap = stringToMap(rule);
        HashMap<String, Object> objMap = (HashMap<String, Object>) objectToMap(user);
        AtomicBoolean returnFlag = new AtomicBoolean(false);
        ruleMap.forEach((k, v) -> {
            Object tmpValue = objMap.get(k);
            switch (v) {
                case "NOTNULL" :
                    returnFlag.set(!(java.lang.String.valueOf(tmpValue).isEmpty()));
                    break;
                case "PHONE_REG" :
                    returnFlag.set(CommonUtil.regCheck("PHONE_REG", java.lang.String.valueOf(tmpValue)));
                    break;
                case "EMAIL_REG" :
                    returnFlag.set(CommonUtil.regCheck("EMAIL_REG", java.lang.String.valueOf(tmpValue)));
                    break;
                case "ID_REG" :
                    returnFlag.set(CommonUtil.regCheck("ID_REG", java.lang.String.valueOf(tmpValue)));
                    break;
                default:
                    returnFlag.set(true);
                    break;
            }
            if (!returnFlag.get()) {
                return;
            }
        });
        return returnFlag.get();
    }

}
