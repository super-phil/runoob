package com.ssm.runoob.service;

import com.ssm.runoob.model.User;

import java.util.List;
import java.util.Map;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Delete by primary key int.
     *
     * @param id the id
     * @return the int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * Insert int.
     *
     * @param record the record
     * @return the int
     */
    int insert(User record);

    /**
     * Insert selective int.
     *
     * @param record the record
     * @return the int
     */
    int insertSelective(User record);

    /**
     * Select by primary key user.
     *
     * @param id the id
     * @return the user
     */
    User selectByPrimaryKey(Long id);

    /**
     * Update by primary key selective int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * Update by primary key int.
     *
     * @param record the record
     * @return the int
     */
    int updateByPrimaryKey(User record);

    /**
     * Find by query and order by list.
     *
     * @param q       the q
     * @param orderBy the order by
     * @param start   the start
     * @param end     the end
     * @return the list
     */
    List<User> findByQueryAndOrderBy(String q, String orderBy, int start, int end);

    /**
     * Count long.
     *
     * @return the long
     */
    long count();

    /**
     * Count by query long.
     *
     * @param q the q
     * @return the long
     */
    long countByQuery(String q);

    /**
     * Gets interval data.
     *
     * @param i the
     * @return the interval data
     */
    Map<String, Object> getIntervalData(int i);

    /**
     * Find by mobile password user.
     *
     * @param mobile   the mobile
     * @param password the password
     * @return the user
     */
    User findByMobilePassword(String mobile, String password);

    /**
     * Insert assign int.
     *
     * @param uid the uid
     * @param rid the rid
     * @return the int
     */
    int insertAssign(Long uid, Long rid);

    /**
     * Remove assign int.
     *
     * @param uid the uid
     * @return the int
     */
    int removeAssign(Long uid);
}
