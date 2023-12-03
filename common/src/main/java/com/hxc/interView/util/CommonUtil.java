package com.hxc.interView.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    public static HashMap<String, String> stringToMap(String str) {
        String[] entries = str.split(",");
        HashMap<String, String> map = new HashMap<>();
        for (String entry : entries) {
            String[] keyValue = entry.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

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

}
