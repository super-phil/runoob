package com.ssm.runoob.service.impl;

import com.ssm.runoob.dao.RoleMapper;
import com.ssm.runoob.model.Privilege;
import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.RolePrivilege;
import com.ssm.runoob.service.RoleService;
import com.ssm.runoob.util.ShiroUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Phil on 2016/4/15.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    /**
     * 默认roles字符串
     */
    public static final String ROLES_STRING = "roles %s";
    private final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private RoleMapper roleMapper;
    @Autowired(required = false)//容器启动后使用时初始化
    private ShiroFilterFactoryBean shiroFilterFactoryBean;

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
        removeAssignAllByRID(list.get(0).getRoleId());//

        int i = roleMapper.insertAssign(list);
        return i;
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

    @Override
    public List<Role> getAllRolePrivilege() {
        return roleMapper.getAllRolePrivilege();
    }


    @Override
    public void loadFilterChainDefinitions() {
        Map<String, String> map = getFilterChainDefinitions();
        Map<String, String> filterChainDefinitionMap = shiroFilterFactoryBean.getFilterChainDefinitionMap();
        filterChainDefinitionMap.clear();//清空原有规则
        filterChainDefinitionMap.putAll(ShiroUtils.getDefaultFilterChainDefinitionMap());
        filterChainDefinitionMap.putAll(map);
    }

    @Override
    public Map<String, String> getFilterChainDefinitions() {
        List<Role> rps = getAllRolePrivilege();
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (Role role : rps) {
            for (Privilege privilege : role.getPrivileges()) {
                String roleName = role.getName();
                String url = privilege.getUrl();
                List<String> vs = map.get(url);//已有角色
                if (StringUtils.isNotBlank(url)) {
                    if (map.containsKey(url)) {//已包含Key
                        if (!vs.contains(roleName)) { //没在里面
                            vs.add(roleName);
                        }
                        map.put(url, vs);
                    } else {//没有包含Key
                        if (null != vs && !vs.contains(roleName)) { //没在里面
                            vs.add(roleName);
                        } else {
                            vs = new ArrayList<>();
                            vs.add(roleName);
                        }
                        map.put(url, vs);
                    }
                }
            }
        }
        Map<String, String> rmp = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String url = entry.getKey();
            String roles = Arrays.toString(entry.getValue().toArray(new String[]{}));
            if (StringUtils.isNotBlank(url) && StringUtils.isNotBlank(roles)) {
                rmp.put(url, String.format(ROLES_STRING, roles));
            }
        }
        return rmp;
    }
}
