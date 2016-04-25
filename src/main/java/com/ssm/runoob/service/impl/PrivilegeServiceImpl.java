package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.PrivilegeMapper;
import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {
    @Autowired
    private PrivilegeMapper privilegeMapper;

    @Cacheable(value = "privilege", key = "#search+'.'+#order+'.'+#start+'.'+#length")
    @Override
    public List<Privilege> findByQueryAndOrderBy(String search, String order, int start, int length) {
        return privilegeMapper.findByQueryAndOrderBy(search, order, start, length);
    }

    @Cacheable(value = "privilege")
    @Override
    public long count() {
        return privilegeMapper.count();
    }

    @Cacheable(value = "privilege", key = "#search")
    @Override
    public long countByQuery(String search) {
        return privilegeMapper.countByQuery(search);
    }

    @CacheEvict(value = "privilege", key = "#privilege.id", allEntries = true)
    @Override
    public int insert(Privilege privilege) {
        return privilegeMapper.insertSelective(privilege);
    }


    @CacheEvict(value = "privilege", key = "#privilege.id", allEntries = true)
    @Override
    public int updateByPrimaryKeySelective(Privilege privilege) {
        return privilegeMapper.updateByPrimaryKeySelective(privilege);
    }
    @CacheEvict(value = "privilege", key = "#id", allEntries = true)
    @Override
    public int deleteByPrimaryKey(long id) {
        //删除关联关系
        privilegeMapper.removeRPassignByPID(id);
        return privilegeMapper.deleteByPrimaryKey(id);
    }

    @Cacheable(value = "privilege", key = "#pName")
    @Override
    public Privilege findByName(String pName) {
        return privilegeMapper.findByName(pName);
    }

    @Cacheable(value = "privilege", key = "#pid")
    @Override
    public List<Privilege> findByPID(long pid) {
        return privilegeMapper.findByPID(pid);
    }
}
