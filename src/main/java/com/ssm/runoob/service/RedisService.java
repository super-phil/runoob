package com.ssm.runoob.service;

/**
 * Created by Phil on 2016/3/28.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface RedisService<K,V> {
    /**
     * Set.
     *
     * @param k the k
     * @param v the v
     */
    void set(K k,V v);

    /**
     * Get v.
     *
     * @param k the k
     * @return the v
     */
    V get(K k);

    /**
     * Del.
     *
     * @param k the k
     */
    void del(K k);

    /**
     * Exists boolean.
     *
     * @param k the k
     * @return the boolean
     */
    boolean exists(K k);
}
