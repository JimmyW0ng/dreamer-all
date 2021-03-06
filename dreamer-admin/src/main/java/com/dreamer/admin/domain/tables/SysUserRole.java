/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables;


import com.dreamer.admin.domain.Dreamer;
import com.dreamer.admin.domain.Keys;
import com.dreamer.admin.domain.tables.records.SysUserRoleRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


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
public class SysUserRole extends TableImpl<SysUserRoleRecord> {

    /**
     * The reference instance of <code>dreamer.sys_user_role</code>
     */
    public static final SysUserRole SYS_USER_ROLE = new SysUserRole();
    private static final long serialVersionUID = -1094293563;
    /**
     * The column <code>dreamer.sys_user_role.id</code>.
     */
    public final TableField<SysUserRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");
    /**
     * The column <code>dreamer.sys_user_role.sys_user_id</code>. 用户编号
     */
    public final TableField<SysUserRoleRecord, Long> SYS_USER_ID = createField("sys_user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "用户编号");
    /**
     * The column <code>dreamer.sys_user_role.sys_role_id</code>. 角色编号
     */
    public final TableField<SysUserRoleRecord, Long> SYS_ROLE_ID = createField("sys_role_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "角色编号");

    /**
     * Create a <code>dreamer.sys_user_role</code> table reference
     */
    public SysUserRole() {
        this("sys_user_role", null);
    }

    /**
     * Create an aliased <code>dreamer.sys_user_role</code> table reference
     */
    public SysUserRole(String alias) {
        this(alias, SYS_USER_ROLE);
    }

    private SysUserRole(String alias, Table<SysUserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysUserRole(String alias, Table<SysUserRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "用户-角色");
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysUserRoleRecord> getRecordType() {
        return SysUserRoleRecord.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Dreamer.DREAMER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<SysUserRoleRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_USER_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysUserRoleRecord> getPrimaryKey() {
        return Keys.KEY_SYS_USER_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysUserRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<SysUserRoleRecord>>asList(Keys.KEY_SYS_USER_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRole as(String alias) {
        return new SysUserRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUserRole rename(String name) {
        return new SysUserRole(name, null);
    }
}
