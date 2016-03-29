package com.ssm.runoob.service;

/**
 * Created by Phil on 2016/3/28.
 */
public interface RedisService<K,V> {
    void set(K k,V v);
    V get(K k);
    void del(K k);
    boolean exists(K k);
}
