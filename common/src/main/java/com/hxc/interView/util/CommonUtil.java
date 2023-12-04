package com.hxc.interView.util;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
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
            boolean rs1 = matcher.find();
            boolean rs2 = Pattern.compile(rex_2).matcher(value).find();
            return matcher.find() ? matcher.find() : Pattern.compile(rex_2).matcher(value).find();
        } else {
            return matcher.find();
        }
    }

    /**
     * AES(CBC) 加密
     * @param data    待加密原文（byte）
     * @param key     key
     * @param iv      初始向量参数
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static byte[] encryptCBC(byte[] data, byte[] key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] result = cipher.doFinal(data);
        return result;
    }

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, UnsupportedEncodingException {
        byte[] bytes = encryptCBC("hxc980203@".getBytes(), "123456qazwsxplmk".getBytes(), "123456qazwsxplmk".getBytes());
        System.out.println(new String(bytes, "GBK"));


        byte[] bytes2 = decryptCBC(bytes, "123456qazwsxplmk".getBytes(), "123456qazwsxplmk".getBytes());
        System.out.println(Arrays.equals(bytes2, "hxc980203@".getBytes()));
    }


    /**
     * AES(CBC) 解密
     * @param data   密文
     * @param key    key
     * @param iv     初始向量
     * @return
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     */
    public static byte[] decryptCBC(byte[] data, byte[] key, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        byte[] result = cipher.doFinal(data);
        return result;
    }

}

