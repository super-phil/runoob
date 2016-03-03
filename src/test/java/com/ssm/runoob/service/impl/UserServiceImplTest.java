package com.ssm.runoob.service.impl;

import com.alibaba.fastjson.JSON;
import com.ssm.runoob.BaseTest;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;
    private static final Logger LOG = Logger.getLogger(UserServiceImplTest.class);

    /**
     * Test delete by primary key.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    /**
     * Test insert.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setName("nike");
        long insert = userService.insert(user);
        LOG.info(user.getId());

    }

    /**
     * Test insert selective.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testInsertSelective() throws Exception {
        User user = new User();
        user.setName("nike");
        LOG.info(userService.insertSelective(user));
    }

    /**
     * Test select by primary key.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testSelectByPrimaryKey() throws Exception {
        LOG.info(JSON.toJSONString(userService.selectByPrimaryKey(33L)));
    }

    /**
     * Test update by primary key selective.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {
        User user = userService.selectByPrimaryKey(1L);
        user.setEmail("717@163.com");
        userService.updateByPrimaryKeySelective(user);
        LOG.info(JSON.toJSONString(user));
    }

    /**
     * Test update by primary key.
     *
     * @throws Exception the exception
     * @author Phil
     */
    @Test
    public void testUpdateByPrimaryKey() throws Exception {
        User user = userService.selectByPrimaryKey(5L);
        user.setEmail("7187@163.com");
        userService.updateByPrimaryKey(user);
        LOG.info(JSON.toJSONString(user));
    }
}