package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.UserMapper;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            logger.debug("Del user to database success");
        } else {
            logger.debug("Del user to database error!");
        }
        return i;
    }

    @Override
    public int insert(User record) {
        int i = userMapper.insert(record);
        if (i > 0) {
            logger.debug("Insert user to database success");
        } else {
            logger.debug("Insert user to database error!");
        }
        return i;
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

    @Override
    public List<User> findByQueryAndOrderBy(String q, String orderBy, int start, int end) {
        return userMapper.findByQueryAndOrderBy(q, orderBy, start, end);
    }

    @Override
    public long count() {
        return userMapper.count();
    }

    @Override
    public long countByQuery(String q) {
        return userMapper.countByQuery(q);
    }

    @Override
    public Map<String, Object> getIntervalData(int i) {
        return userMapper.getIntervalData(i);
    }

    @Override
    public User findByMobilePassword(String mobile, String password) {
        return userMapper.findByMobilePassword(mobile,password);
    }
}
