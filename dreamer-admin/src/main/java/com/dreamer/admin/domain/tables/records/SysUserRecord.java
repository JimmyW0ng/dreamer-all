/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables.records;


import com.dreamer.admin.domain.enums.SysUserStatus;
import com.dreamer.admin.domain.tables.SysUser;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record16;
import org.jooq.Row16;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


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
public class SysUserRecord extends UpdatableRecordImpl<SysUserRecord> implements Record16<Long, String, String, String, String, String, String, String, SysUserStatus, String, Timestamp, String, Timestamp, Timestamp, String, Boolean> {

    private static final long serialVersionUID = 871076178;

    /**
     * Create a detached SysUserRecord
     */
    public SysUserRecord() {
        super(SysUser.SYS_USER);
    }

    /**
     * Create a detached, initialised SysUserRecord
     */
    public SysUserRecord(Long id, String loginName, String password, String no, String name, String email, String phone, String mobile, SysUserStatus status, String loginIp, Timestamp loginTime, String avatars, Timestamp createAt, Timestamp updateAt, String remarks, Boolean delFlag) {
        super(SysUser.SYS_USER);

        set(0, id);
        set(1, loginName);
        set(2, password);
        set(3, no);
        set(4, name);
        set(5, email);
        set(6, phone);
        set(7, mobile);
        set(8, status);
        set(9, loginIp);
        set(10, loginTime);
        set(11, avatars);
        set(12, createAt);
        set(13, updateAt);
        set(14, remarks);
        set(15, delFlag);
    }

    /**
     * Getter for <code>dreamer.sys_user.id</code>. 编号
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>dreamer.sys_user.id</code>. 编号
     */
    public SysUserRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.login_name</code>. 登录名
     */
    public String getLoginName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>dreamer.sys_user.login_name</code>. 登录名
     */
    public SysUserRecord setLoginName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.password</code>. 密码
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>dreamer.sys_user.password</code>. 密码
     */
    public SysUserRecord setPassword(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.no</code>. 工号
     */
    public String getNo() {
        return (String) get(3);
    }

    /**
     * Setter for <code>dreamer.sys_user.no</code>. 工号
     */
    public SysUserRecord setNo(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.name</code>. 姓名
     */
    public String getName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>dreamer.sys_user.name</code>. 姓名
     */
    public SysUserRecord setName(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.email</code>. 邮箱
     */
    public String getEmail() {
        return (String) get(5);
    }

    /**
     * Setter for <code>dreamer.sys_user.email</code>. 邮箱
     */
    public SysUserRecord setEmail(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.phone</code>. 电话
     */
    public String getPhone() {
        return (String) get(6);
    }

    /**
     * Setter for <code>dreamer.sys_user.phone</code>. 电话
     */
    public SysUserRecord setPhone(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.mobile</code>. 手机
     */
    public String getMobile() {
        return (String) get(7);
    }

    /**
     * Setter for <code>dreamer.sys_user.mobile</code>. 手机
     */
    public SysUserRecord setMobile(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.status</code>. 状态
     */
    public SysUserStatus getStatus() {
        return (SysUserStatus) get(8);
    }

    /**
     * Setter for <code>dreamer.sys_user.status</code>. 状态
     */
    public SysUserRecord setStatus(SysUserStatus value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.login_ip</code>. 最后登陆IP
     */
    public String getLoginIp() {
        return (String) get(9);
    }

    /**
     * Setter for <code>dreamer.sys_user.login_ip</code>. 最后登陆IP
     */
    public SysUserRecord setLoginIp(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.login_time</code>. 最后登陆时间
     */
    public Timestamp getLoginTime() {
        return (Timestamp) get(10);
    }

    /**
     * Setter for <code>dreamer.sys_user.login_time</code>. 最后登陆时间
     */
    public SysUserRecord setLoginTime(Timestamp value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.avatars</code>. 头像URL
     */
    public String getAvatars() {
        return (String) get(11);
    }

    /**
     * Setter for <code>dreamer.sys_user.avatars</code>. 头像URL
     */
    public SysUserRecord setAvatars(String value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.create_at</code>. 创建时间
     */
    public Timestamp getCreateAt() {
        return (Timestamp) get(12);
    }

    /**
     * Setter for <code>dreamer.sys_user.create_at</code>. 创建时间
     */
    public SysUserRecord setCreateAt(Timestamp value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.update_at</code>. 更新时间
     */
    public Timestamp getUpdateAt() {
        return (Timestamp) get(13);
    }

    /**
     * Setter for <code>dreamer.sys_user.update_at</code>. 更新时间
     */
    public SysUserRecord setUpdateAt(Timestamp value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_user.remarks</code>. 备注信息
     */
    public String getRemarks() {
        return (String) get(14);
    }

    /**
     * Setter for <code>dreamer.sys_user.remarks</code>. 备注信息
     */
    public SysUserRecord setRemarks(String value) {
        set(14, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>dreamer.sys_user.del_flag</code>. 删除标志
     */
    public Boolean getDelFlag() {
        return (Boolean) get(15);
    }

    // -------------------------------------------------------------------------
    // Record16 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>dreamer.sys_user.del_flag</code>. 删除标志
     */
    public SysUserRecord setDelFlag(Boolean value) {
        set(15, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, String, String, String, String, String, String, String, SysUserStatus, String, Timestamp, String, Timestamp, Timestamp, String, Boolean> fieldsRow() {
        return (Row16) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row16<Long, String, String, String, String, String, String, String, SysUserStatus, String, Timestamp, String, Timestamp, Timestamp, String, Boolean> valuesRow() {
        return (Row16) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysUser.SYS_USER.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysUser.SYS_USER.LOGIN_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysUser.SYS_USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysUser.SYS_USER.NO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysUser.SYS_USER.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SysUser.SYS_USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return SysUser.SYS_USER.PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return SysUser.SYS_USER.MOBILE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<SysUserStatus> field9() {
        return SysUser.SYS_USER.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return SysUser.SYS_USER.LOGIN_IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return SysUser.SYS_USER.LOGIN_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field12() {
        return SysUser.SYS_USER.AVATARS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field13() {
        return SysUser.SYS_USER.CREATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field14() {
        return SysUser.SYS_USER.UPDATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field15() {
        return SysUser.SYS_USER.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field16() {
        return SysUser.SYS_USER.DEL_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getLoginName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getNo();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getMobile();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserStatus value9() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getLoginIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getLoginTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value12() {
        return getAvatars();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value13() {
        return getCreateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value14() {
        return getUpdateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value15() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value16() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value2(String value) {
        setLoginName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value4(String value) {
        setNo(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value5(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value6(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value7(String value) {
        setPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value8(String value) {
        setMobile(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value9(SysUserStatus value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value10(String value) {
        setLoginIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value11(Timestamp value) {
        setLoginTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value12(String value) {
        setAvatars(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value13(Timestamp value) {
        setCreateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value14(Timestamp value) {
        setUpdateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value15(String value) {
        setRemarks(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord value16(Boolean value) {
        setDelFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysUserRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, String value7, String value8, SysUserStatus value9, String value10, Timestamp value11, String value12, Timestamp value13, Timestamp value14, String value15, Boolean value16) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        return this;
    }
}
