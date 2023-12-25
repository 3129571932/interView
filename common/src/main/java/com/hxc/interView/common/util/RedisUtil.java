package com.hxc.interView.common.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 普通缓存放入
     * @param key
     * @param value
     * @return
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 放入缓存并且设置超时时间（秒）
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean set(String  key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * 普通缓存获取
     * @param key
     * @return
     */
    public Object get(String key) {
        return null == key ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存（key可以穿一个或者多个）
     * @param key
     */
    public void del(String... key) {
        if (null != key && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }

}
