package com.hxc.interView.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {

    /**
     * String转成map
     * @param str
     * @return
     */
    public static HashMap<String, String> stringToMap(String str) {
        String[] entries = str.split(",");
        HashMap<String, String> map = new HashMap<>();
        for (String entry : entries) {
            String[] keyValue = entry.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

    /**
     * obj转map
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        HashMap<String, Object> resMap = new HashMap<>();
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String keyName = field.getName();
            Object value = field.get(obj);
            resMap.put(keyName, null == value ? "" : value);
        }
        return resMap;
    }

    /**
     * 正则判断
     * @param regName
     * @param value
     * @return
     */
    public static boolean regCheck(String regName, String value) {
        String rex = "", rex_2 = "";
        boolean resFlag = false;
        switch (regName) {
            case "PHONE_REG" :
                rex = "^1([34578])\\d{9}$";
                break;
            case "EMAIL_REG" :
                rex = "^(.+)@(.+)$";
                break;
            case "ID_REG" :
                rex = "^[1-9]\\\\d{5}\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}$\n";
                rex_2 = "^[1-9]\\\\d{5}(18|19|([23]\\\\d))\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}[0-9Xx]$";
        }
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(value);
        if (regName.equals("ID_REG")) {
            //身份证一代二代都需要验证
            return matcher.find() ? matcher.find() : Pattern.compile(rex_2).matcher(value).find();
        } else {
            return matcher.find();
        }
    }

}
