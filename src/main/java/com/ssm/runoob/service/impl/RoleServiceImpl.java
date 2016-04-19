package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.RoleMapper;
import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.RolePrivilege;
import com.ssm.runoob.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Phil on 2016/4/15.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findByQueryAndOrderBy(String search, String order, int start, int length) {
        return roleMapper.findByQueryAndOrderBy(search, order, start, length);
    }

    @Override
    public long count() {
        return roleMapper.count();
    }

    @Override
    public long countByQuery(String search) {
        return roleMapper.countByQuery(search);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int updateByPrimaryKeySelective(Role role) {
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public int deleteByPrimaryKey(long id) {
        removeAssignAllByRID(id);
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertAssign(List<RolePrivilege> list) {
        if (null == list || list.size() == 0) return -1;
        removeAssignAllByRID(list.get(0).getRoleId());
        return roleMapper.insertAssign(list);
    }

    @Override
    public int removeAssignAllByRID(Long rid) {
        //删除中间表 关联关系
        return roleMapper.removeRPAssignAllByRID(rid);
    }

    @Override
    public List<Role> getAll() {
        return roleMapper.getAll();
    }
}
