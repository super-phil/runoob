package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.PrivilegeMapper;
import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.model.TreeNode;
import com.ssm.runoob.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Override
    public List<Privilege> findByQueryAndOrderBy(String search, String order, int start, int length) {
        return privilegeMapper.findByQueryAndOrderBy(search, order, start, length);
    }

    @Override
    public long count() {
        return privilegeMapper.count();
    }

    @Override
    public long countByQuery(String search) {
        return privilegeMapper.countByQuery(search);
    }

    @Override
    public int insert(Privilege privilege) {
        return privilegeMapper.insertSelective(privilege);
    }

    @Override
    public int updateByPrimaryKeySelective(Privilege privilege) {
        return privilegeMapper.updateByPrimaryKeySelective(privilege);
    }

    @Override
    public int deleteByPrimaryKey(long id) {
        //删除关联关系
        privilegeMapper.removeRPassignByPID(id);
        return privilegeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Privilege findByName(String pName) {
        return privilegeMapper.findByName(pName);
    }

    @Override
    public List<Privilege> findByPID(long pid) {
        return privilegeMapper.findByPID(pid);
    }
}
