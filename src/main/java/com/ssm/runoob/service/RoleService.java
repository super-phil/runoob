package com.ssm.runoob.service;

import com.ssm.runoob.model.Role;
import com.ssm.runoob.model.RolePrivilege;

import java.util.List;
import java.util.Map;

/**
 * Created by Phil on 2016/4/15.
 */
public interface RoleService {
    /**
     * Find by query and order by list.
     *
     * @param search the search
     * @param order  the order
     * @param start  the start
     * @param length the length
     * @return the list
     */
    List<Role> findByQueryAndOrderBy(String search, String order, int start, int length);

    /**
     * Count long.
     *
     * @return the long
     */
    long count();

    /**
     * Count by query long.
     *
     * @param search the search
     * @return the long
     */
    long countByQuery(String search);

    /**
     * Insert int.
     *
     * @param role the role
     * @return the int
     */
    int insert(Role role);

    /**
     * Update by primary key selective int.
     *
     * @param role the role
     * @return the int
     */
    int updateByPrimaryKeySelective(Role role);

    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(long id);

    /**
     * Insert assign int.
     *
     * @param list the list
     * @return the int
     */
    int insertAssign(List<RolePrivilege> list);

    /**
     * Remove assign all by rid int.
     *
     * @param rid the rid
     * @return the int
     */
    int removeAssignAllByRID(Long rid);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Role> getAll();

    /**
     * Gets all role privilege.
     *
     * @return the all role privilege
     */
    List<Role> getAllRolePrivilege();

    /**
     * Load filter chain definitions.
     */
    void loadFilterChainDefinitions();

    /**
     * Gets filter chain definitions.
     *
     * @return the filter chain definitions
     */
    Map<String, String> getFilterChainDefinitions();
}
