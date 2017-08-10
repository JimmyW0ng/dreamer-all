/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables;


import com.dreamer.domain.Jw;
import com.dreamer.domain.Keys;
import com.dreamer.domain.tables.records.SysUserRoleRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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

    private static final long serialVersionUID = -760656462;

    /**
     * The reference instance of <code>jw.sys_user_role</code>
     */
    public static final SysUserRole SYS_USER_ROLE = new SysUserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysUserRoleRecord> getRecordType() {
        return SysUserRoleRecord.class;
    }

    /**
     * The column <code>jw.sys_user_role.id</code>.
     */
    public final TableField<SysUserRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>jw.sys_user_role.sys_user_id</code>. 用户编号
     */
    public final TableField<SysUserRoleRecord, Long> SYS_USER_ID = createField("sys_user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "用户编号");

    /**
     * The column <code>jw.sys_user_role.sys_role_id</code>. 角色编号
     */
    public final TableField<SysUserRoleRecord, Long> SYS_ROLE_ID = createField("sys_role_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "角色编号");

    /**
     * Create a <code>jw.sys_user_role</code> table reference
     */
    public SysUserRole() {
        this("sys_user_role", null);
    }

    /**
     * Create an aliased <code>jw.sys_user_role</code> table reference
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
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Jw.JW;
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