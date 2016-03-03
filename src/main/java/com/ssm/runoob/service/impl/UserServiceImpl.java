package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.UserMapper;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        int temp;
        int temp1 = 0;
        temp = userMapper.insert(record);
//        if (1 == 1) {//测试事物
//            throw new NullPointerException("测试测试事物!");
//        }
//        temp1 = usersMapper.insert(record);
        return temp + temp1;
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
