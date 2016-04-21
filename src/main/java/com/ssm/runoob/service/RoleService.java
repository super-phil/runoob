package com.ssm.runoob.service;

import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.RolePrivilege;

import java.util.List;
import java.util.Map;

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

    int insertAssign(List<RolePrivilege> list);

    int removeAssignAllByRID(Long rid);

    List<Role> getAll();

    List<Role> getAllRolePrivilege();

    void loadFilterChainDefinitions();

    Map<String, String> getFilterChainDefinitions();
}
