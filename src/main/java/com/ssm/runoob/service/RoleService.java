package com.ssm.runoob.service;

import com.ssm.runoob.model.Role;

import java.util.List;

/**
 * Created by Phil on 2016/4/15.
 */
public interface RoleService {
    List<Role> findByQueryAndOrderBy(String search, String order, int start, int length);

    long count();

    long countByQuery(String search);

    int insert(Role role);

    int updateByPrimaryKeySelective(Role role);

    int deleteByPrimaryKey(long id);
}
