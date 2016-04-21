package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.UserMapper;
import com.ssm.runoob.model.User;
import com.ssm.runoob.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Phil on 2016/2/25.
 *
 * @author Phil
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    private final Logger logger = Logger.getLogger(this.getClass());
    @Override
    public int deleteByPrimaryKey(Long id) {
        //删除user_role 关联关系
        removeAssign(id);
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
        record.setPwd(DigestUtils.md5Hex(record.getPwd()));
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
        password = DigestUtils.md5Hex(password);
        return userMapper.findByMobilePassword(mobile, password);
    }

    @Override
    public int insertAssign(Long uid, Long rid) {
        removeAssign(uid);//先删除 再增加
        return userMapper.insertAssign(uid, rid);
    }

    @Override
    public int removeAssign(Long uid) {
        return userMapper.removeAssign(uid);
    }

}
