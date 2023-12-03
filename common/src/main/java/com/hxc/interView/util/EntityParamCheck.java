package com.hxc.interView.util;

import com.hxc.interView.entity.User;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
        Iterator<Map.Entry<String, String>> iterator = ruleMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            Object tmpValue = objMap.get(next.getKey());
            switch (next.getValue()) {
                case "NOTNULL" :
                    returnFlag.set(!(String.valueOf(tmpValue).isEmpty()));
                    break;
                case "PHONE_REG" :
                    returnFlag.set(CommonUtil.regCheck("PHONE_REG", String.valueOf(tmpValue)));
                    break;
                case "EMAIL_REG" :
                    returnFlag.set(CommonUtil.regCheck("EMAIL_REG", String.valueOf(tmpValue)));
                    break;
                case "ID_REG" :
                    returnFlag.set(CommonUtil.regCheck("ID_REG", String.valueOf(tmpValue)));
                    break;
                default:
                    returnFlag.set(true);
                    break;
            }
            if (!returnFlag.get()) {
                break;
            }
        }
        return returnFlag.get();
    }

}
