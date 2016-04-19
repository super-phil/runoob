package com.ssm.runoob.service;

import com.ssm.runoob.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByQueryAndOrderBy(String q, String orderBy, int start, int end);

    long count();

    long countByQuery(String q);

    Map<String, Object> getIntervalData(int i);

    User findByMobilePassword(String mobile, String password);

    int insertAssign(Long uid, Long rid);
    int removeAssign(Long uid);
}
