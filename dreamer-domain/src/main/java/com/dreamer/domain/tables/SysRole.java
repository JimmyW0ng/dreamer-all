/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables;


import com.dreamer.domain.Jw;
import com.dreamer.domain.Keys;
import com.dreamer.domain.tables.records.SysRoleRecord;

import java.sql.Timestamp;
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
public class SysRole extends TableImpl<SysRoleRecord> {

    private static final long serialVersionUID = -452165008;

    /**
     * The reference instance of <code>jw.sys_role</code>
     */
    public static final SysRole SYS_ROLE = new SysRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRoleRecord> getRecordType() {
        return SysRoleRecord.class;
    }

    /**
     * The column <code>jw.sys_role.id</code>. 编号
     */
    public final TableField<SysRoleRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "编号");

    /**
     * The column <code>jw.sys_role.name</code>. 角色名称
     */
    public final TableField<SysRoleRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "角色名称");

    /**
     * The column <code>jw.sys_role.create_by</code>. 创建者
     */
    public final TableField<SysRoleRecord, String> CREATE_BY = createField("create_by", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "创建者");

    /**
     * The column <code>jw.sys_role.create_at</code>. 创建时间
     */
    public final TableField<SysRoleRecord, Timestamp> CREATE_AT = createField("create_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");

    /**
     * The column <code>jw.sys_role.update_by</code>. 更新者
     */
    public final TableField<SysRoleRecord, String> UPDATE_BY = createField("update_by", org.jooq.impl.SQLDataType.VARCHAR.length(64), this, "更新者");

    /**
     * The column <code>jw.sys_role.update_at</code>. 更新时间
     */
    public final TableField<SysRoleRecord, Timestamp> UPDATE_AT = createField("update_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "更新时间");

    /**
     * The column <code>jw.sys_role.remarks</code>. 备注信息
     */
    public final TableField<SysRoleRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "备注信息");

    /**
     * The column <code>jw.sys_role.del_flag</code>. 删除标记
     */
    public final TableField<SysRoleRecord, Boolean> DEL_FLAG = createField("del_flag", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'1'", org.jooq.impl.SQLDataType.BIT)), this, "删除标记");

    /**
     * Create a <code>jw.sys_role</code> table reference
     */
    public SysRole() {
        this("sys_role", null);
    }

    /**
     * Create an aliased <code>jw.sys_role</code> table reference
     */
    public SysRole(String alias) {
        this(alias, SYS_ROLE);
    }

    private SysRole(String alias, Table<SysRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRole(String alias, Table<SysRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "角色表");
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
    public Identity<SysRoleRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysRoleRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysRoleRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRoleRecord>>asList(Keys.KEY_SYS_ROLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRole as(String alias) {
        return new SysRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRole rename(String name) {
        return new SysRole(name, null);
    }
}