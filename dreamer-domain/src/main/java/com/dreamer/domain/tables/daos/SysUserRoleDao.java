/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables.daos;


import com.dreamer.domain.tables.SysUserRole;
import com.dreamer.domain.tables.pojos.SysUserRolePojo;
import com.dreamer.domain.tables.records.SysUserRoleRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.Record3;
import org.jooq.impl.DAOImpl;


/**
 * 用户-角色
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUserRoleDao extends DAOImpl<SysUserRoleRecord, SysUserRolePojo, Record3<Long, Long, Long>> {

    /**
     * Create a new SysUserRoleDao without any configuration
     */
    public SysUserRoleDao() {
        super(SysUserRole.SYS_USER_ROLE, SysUserRolePojo.class);
    }

    /**
     * Create a new SysUserRoleDao with an attached configuration
     */
    public SysUserRoleDao(Configuration configuration) {
        super(SysUserRole.SYS_USER_ROLE, SysUserRolePojo.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Record3<Long, Long, Long> getId(SysUserRolePojo object) {
        return compositeKeyRecord(object.getId(), object.getSysUserId(), object.getSysRoleId());
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<SysUserRolePojo> fetchById(Long... values) {
        return fetch(SysUserRole.SYS_USER_ROLE.ID, values);
    }

    /**
     * Fetch records that have <code>sys_user_id IN (values)</code>
     */
    public List<SysUserRolePojo> fetchBySysUserId(Long... values) {
        return fetch(SysUserRole.SYS_USER_ROLE.SYS_USER_ID, values);
    }

    /**
     * Fetch records that have <code>sys_role_id IN (values)</code>
     */
    public List<SysUserRolePojo> fetchBySysRoleId(Long... values) {
        return fetch(SysUserRole.SYS_USER_ROLE.SYS_ROLE_ID, values);
    }
}
