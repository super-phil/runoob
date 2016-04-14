package com.ssm.runoob.service.impl;

import com.ssm.runoob.BaseTest;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.RedisService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RedisServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre></pre>
 */
public class RedisServiceImplTest extends BaseTest {

    @Autowired
    private RedisService<String, User> redisService;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: set(K k, V v)
     */
    @Test
    public void testSet() throws Exception {
//        System.out.println("xxxx");
        redisService.set("user", new User());
    }

    /**
     * Method: get(K k)
     */
    @Test
    public void testGet() throws Exception {
        logger.debug(redisService.get("user"));

    }

    /**
     * Method: del(K k)
     */
    @Test
    public void testDel() throws Exception {
        redisService.del("user");
    }

    /**
     * Method: exists(K k)
     */
    @Test
    public void testExists() throws Exception {
        logger.debug(redisService.exists("user"));
    }


} 
