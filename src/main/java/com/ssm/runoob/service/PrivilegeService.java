package com.ssm.runoob.service;

import com.ssm.runoob.model.Privilege;

import java.util.List;

/**
 * Created by Phil on 2016/4/18.
 */
public interface PrivilegeService {
    /**
     * Find by query and order by list.
     *
     * @param search the search
     * @param order  the order
     * @param start  the start
     * @param length the length
     * @return the list
     */
    List<Privilege> findByQueryAndOrderBy(String search, String order, int start, int length);

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
     * @param privilege the privilege
     * @return the int
     */
    int insert(Privilege privilege);

    /**
     * Update by primary key selective int.
     *
     * @param privilege the privilege
     * @return the int
     */
    int updateByPrimaryKeySelective(Privilege privilege);

    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(long id);

    /**
     * Find by name privilege.
     *
     * @param pName the p name
     * @return the privilege
     */
    Privilege findByName(String pName);

    /**
     * Find by pid list.
     *
     * @param pid the pid
     * @return the list
     */
    List<Privilege> findByPID(long pid);


}
