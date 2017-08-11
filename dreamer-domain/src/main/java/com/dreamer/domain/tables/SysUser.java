/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables;


import com.dreamer.domain.Dreamer;
import com.dreamer.domain.Keys;
import com.dreamer.domain.enums.SysUserStatus;
import com.dreamer.domain.tables.records.SysUserRecord;
import org.jooq.*;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


/**
 * 用户表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysUser extends TableImpl<SysUserRecord> {

    /**
     * The reference instance of <code>dreamer.sys_user</code>
     */
    public static final SysUser SYS_USER = new SysUser();
    private static final long serialVersionUID = -2102412403;
    /**
     * The column <code>dreamer.sys_user.id</code>. 编号
     */
    public final TableField<SysUserRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "编号");
    /**
     * The column <code>dreamer.sys_user.login_name</code>. 登录名
     */
    public final TableField<SysUserRecord, String> LOGIN_NAME = createField("login_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "登录名");
    /**
     * The column <code>dreamer.sys_user.password</code>. 密码
     */
    public final TableField<SysUserRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "密码");
    /**
     * The column <code>dreamer.sys_user.no</code>. 工号
     */
    public final TableField<SysUserRecord, String> NO = createField("no", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "工号");
    /**
     * The column <code>dreamer.sys_user.name</code>. 姓名
     */
    public final TableField<SysUserRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("", org.jooq.impl.SQLDataType.VARCHAR)), this, "姓名");
    /**
     * The column <code>dreamer.sys_user.email</code>. 邮箱
     */
    public final TableField<SysUserRecord, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "邮箱");
    /**
     * The column <code>dreamer.sys_user.phone</code>. 电话
     */
    public final TableField<SysUserRecord, String> PHONE = createField("phone", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "电话");
    /**
     * The column <code>dreamer.sys_user.mobile</code>. 手机
     */
    public final TableField<SysUserRecord, String> MOBILE = createField("mobile", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "手机");
    /**
     * The column <code>dreamer.sys_user.status</code>. 状态
     */
    public final TableField<SysUserRecord, SysUserStatus> STATUS = createField("status", org.jooq.util.mysql.MySQLDataType.VARCHAR.asEnumDataType(com.dreamer.domain.enums.SysUserStatus.class), this, "状态");
    /**
     * The column <code>dreamer.sys_user.login_ip</code>. 最后登陆IP
     */
    public final TableField<SysUserRecord, String> LOGIN_IP = createField("login_ip", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "最后登陆IP");
    /**
     * The column <code>dreamer.sys_user.login_time</code>. 最后登陆时间
     */
    public final TableField<SysUserRecord, Timestamp> LOGIN_TIME = createField("login_time", org.jooq.impl.SQLDataType.TIMESTAMP, this, "最后登陆时间");
    /**
     * The column <code>dreamer.sys_user.avatars</code>. 头像URL
     */
    public final TableField<SysUserRecord, String> AVATARS = createField("avatars", org.jooq.impl.SQLDataType.VARCHAR.length(256), this, "头像URL");
    /**
     * The column <code>dreamer.sys_user.create_at</code>. 创建时间
     */
    public final TableField<SysUserRecord, Timestamp> CREATE_AT = createField("create_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "创建时间");
    /**
     * The column <code>dreamer.sys_user.update_at</code>. 更新时间
     */
    public final TableField<SysUserRecord, Timestamp> UPDATE_AT = createField("update_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "更新时间");
    /**
     * The column <code>dreamer.sys_user.remarks</code>. 备注信息
     */
    public final TableField<SysUserRecord, String> REMARKS = createField("remarks", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "备注信息");
    /**
     * The column <code>dreamer.sys_user.del_flag</code>. 删除标志
     */
    public final TableField<SysUserRecord, Boolean> DEL_FLAG = createField("del_flag", org.jooq.impl.SQLDataType.BIT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("b'0'", org.jooq.impl.SQLDataType.BIT)), this, "删除标志");

    /**
     * Create a <code>dreamer.sys_user</code> table reference
     */
    public SysUser() {
        this("sys_user", null);
    }

    /**
     * Create an aliased <code>dreamer.sys_user</code> table reference
     */
    public SysUser(String alias) {
        this(alias, SYS_USER);
    }

    private SysUser(String alias, Table<SysUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysUser(String alias, Table<SysUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "用户表");
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysUserRecord> getRecordType() {
        return SysUserRecord.class;
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
    public Identity<SysUserRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysUserRecord> getPrimaryKey() {
        return Keys.KEY_SYS_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysUserRecord>> getKeys() {
        return Arrays.<UniqueKey<SysUserRecord>>asList(Keys.KEY_SYS_USER_PRIMARY, Keys.KEY_SYS_USER_SYS_USER_LOGIN_NAME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUser as(String alias) {
        return new SysUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysUser rename(String name) {
        return new SysUser(name, null);
    }
}
