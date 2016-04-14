package com.ssm.runoob.service.impl;

import com.ssm.runoob.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Phil on 2016/3/28.
 */
@Service("redisService")
public class RedisServiceImpl<K, V> implements RedisService<K, V> {

    @Autowired
    private RedisTemplate<K, V> redisTemplate;

    @Override
    public void set(K k, V v) {
        redisTemplate.opsForValue().set(k, v);
    }

    @Override
    public V get(K k) {
        return redisTemplate.opsForValue().get(k);
    }

    @Override
    public void del(K k) {
        redisTemplate.delete(k);
    }

    @Override
    public boolean exists(K k) {
        return redisTemplate.hasKey(k);
    }


}
