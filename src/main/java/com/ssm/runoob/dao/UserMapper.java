package com.ssm.runoob.dao;

import com.ssm.runoob.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByQueryAndOrderBy(@Param("q") String q, @Param("orderBy") String orderBy, @Param("start") int start, @Param("end") int end);

    long count();

    long countByQuery(@Param("q") String q);

    Map<String,Object> getIntervalData(@Param("i") int i);

    User findByMobilePassword(@Param("mobile") String mobile, @Param("password") String password);

    int insertAssign(@Param("uid") Long uid, @Param("rid") Long rid);

    int removeAssign(@Param("uid") Long uid);
}