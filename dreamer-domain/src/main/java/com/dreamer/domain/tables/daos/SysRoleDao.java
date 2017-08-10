/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables.daos;


import com.dreamer.domain.tables.SysRole;
import com.dreamer.domain.tables.pojos.SysRolePojo;
import com.dreamer.domain.tables.records.SysRoleRecord;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * 角色表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRoleDao extends DAOImpl<SysRoleRecord, SysRolePojo, Long> {

    /**
     * Create a new SysRoleDao without any configuration
     */
    public SysRoleDao() {
        super(SysRole.SYS_ROLE, SysRolePojo.class);
    }

    /**
     * Create a new SysRoleDao with an attached configuration
     */
    public SysRoleDao(Configuration configuration) {
        super(SysRole.SYS_ROLE, SysRolePojo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Long getId(SysRolePojo object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysRolePojo> fetchById(Long... values) {
        return fetch(SysRole.SYS_ROLE.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public SysRolePojo fetchOneById(Long value) {
        return fetchOne(SysRole.SYS_ROLE.ID, value);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<SysRolePojo> fetchByName(String... values) {
        return fetch(SysRole.SYS_ROLE.NAME, values);
    }

    /**
     * Fetch records that have <code>create_by IN (values)</code>
     */
    public List<SysRolePojo> fetchByCreateBy(String... values) {
        return fetch(SysRole.SYS_ROLE.CREATE_BY, values);
    }

    /**
     * Fetch records that have <code>create_at IN (values)</code>
     */
    public List<SysRolePojo> fetchByCreateAt(Timestamp... values) {
        return fetch(SysRole.SYS_ROLE.CREATE_AT, values);
    }

    /**
     * Fetch records that have <code>update_by IN (values)</code>
     */
    public List<SysRolePojo> fetchByUpdateBy(String... values) {
        return fetch(SysRole.SYS_ROLE.UPDATE_BY, values);
    }

    /**
     * Fetch records that have <code>update_at IN (values)</code>
     */
    public List<SysRolePojo> fetchByUpdateAt(Timestamp... values) {
        return fetch(SysRole.SYS_ROLE.UPDATE_AT, values);
    }

    /**
     * Fetch records that have <code>remarks IN (values)</code>
     */
    public List<SysRolePojo> fetchByRemarks(String... values) {
        return fetch(SysRole.SYS_ROLE.REMARKS, values);
    }

    /**
     * Fetch records that have <code>del_flag IN (values)</code>
     */
    public List<SysRolePojo> fetchByDelFlag(Boolean... values) {
        return fetch(SysRole.SYS_ROLE.DEL_FLAG, values);
    }
}
