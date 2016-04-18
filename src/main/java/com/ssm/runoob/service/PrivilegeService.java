package com.ssm.runoob.service;

import com.ssm.runoob.model.Privilege;

import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
public interface PrivilegeService {
    List<Privilege> findByQueryAndOrderBy(String search, String order, int start, int length);

    long count();

    long countByQuery(String search);

    int insert(Privilege privilege);

    int updateByPrimaryKeySelective(Privilege privilege);

    int deleteByPrimaryKey(long id);
}
