/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables.records;


import com.dreamer.domain.enums.SysDictStatus;
import com.dreamer.domain.tables.SysDict;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 字典表
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysDictRecord extends UpdatableRecordImpl<SysDictRecord> implements Record13<Long, String, String, String, String, String, Integer, SysDictStatus, Timestamp, Timestamp, String, Boolean, Long> {

    private static final long serialVersionUID = 959198334;

    /**
     * Setter for <code>jw.sys_dict.id</code>.
     */
    public SysDictRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>jw.sys_dict.label</code>. 标签名
     */
    public SysDictRecord setLabel(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.label</code>. 标签名
     */
    public String getLabel() {
        return (String) get(1);
    }

    /**
     * Setter for <code>jw.sys_dict.group_name</code>. 组名
     */
    public SysDictRecord setGroupName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.group_name</code>. 组名
     */
    public String getGroupName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>jw.sys_dict.key</code>. key
     */
    public SysDictRecord setKey(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.key</code>. key
     */
    public String getKey() {
        return (String) get(3);
    }

    /**
     * Setter for <code>jw.sys_dict.value</code>. 数据值
     */
    public SysDictRecord setValue(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.value</code>. 数据值
     */
    public String getValue() {
        return (String) get(4);
    }

    /**
     * Setter for <code>jw.sys_dict.description</code>. 描述
     */
    public SysDictRecord setDescription(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.description</code>. 描述
     */
    public String getDescription() {
        return (String) get(5);
    }

    /**
     * Setter for <code>jw.sys_dict.sort</code>. ??????
     */
    public SysDictRecord setSort(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.sort</code>. ??????
     */
    public Integer getSort() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>jw.sys_dict.status</code>.
     */
    public SysDictRecord setStatus(SysDictStatus value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.status</code>.
     */
    public SysDictStatus getStatus() {
        return (SysDictStatus) get(7);
    }

    /**
     * Setter for <code>jw.sys_dict.create_at</code>. 创建时间
     */
    public SysDictRecord setCreateAt(Timestamp value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.create_at</code>. 创建时间
     */
    public Timestamp getCreateAt() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>jw.sys_dict.update_at</code>. 更新时间
     */
    public SysDictRecord setUpdateAt(Timestamp value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.update_at</code>. 更新时间
     */
    public Timestamp getUpdateAt() {
        return (Timestamp) get(9);
    }

    /**
     * Setter for <code>jw.sys_dict.remarks</code>. 备注
     */
    public SysDictRecord setRemarks(String value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.remarks</code>. 备注
     */
    public String getRemarks() {
        return (String) get(10);
    }

    /**
     * Setter for <code>jw.sys_dict.del_flag</code>. 删除标记
     */
    public SysDictRecord setDelFlag(Boolean value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.del_flag</code>. 删除标记
     */
    public Boolean getDelFlag() {
        return (Boolean) get(11);
    }

    /**
     * Setter for <code>jw.sys_dict.version</code>.
     */
    public SysDictRecord setVersion(Long value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>jw.sys_dict.version</code>.
     */
    public Long getVersion() {
        return (Long) get(12);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record13 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, String, String, String, String, String, Integer, SysDictStatus, Timestamp, Timestamp, String, Boolean, Long> fieldsRow() {
        return (Row13) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row13<Long, String, String, String, String, String, Integer, SysDictStatus, Timestamp, Timestamp, String, Boolean, Long> valuesRow() {
        return (Row13) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysDict.SYS_DICT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return SysDict.SYS_DICT.LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return SysDict.SYS_DICT.GROUP_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return SysDict.SYS_DICT.KEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return SysDict.SYS_DICT.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return SysDict.SYS_DICT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return SysDict.SYS_DICT.SORT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<SysDictStatus> field8() {
        return SysDict.SYS_DICT.STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return SysDict.SYS_DICT.CREATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field10() {
        return SysDict.SYS_DICT.UPDATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return SysDict.SYS_DICT.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field12() {
        return SysDict.SYS_DICT.DEL_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field13() {
        return SysDict.SYS_DICT.VERSION;
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
        return getLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getGroupName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getKey();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getSort();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictStatus value8() {
        return getStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getCreateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value10() {
        return getUpdateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value12() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value13() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value2(String value) {
        setLabel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value3(String value) {
        setGroupName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value4(String value) {
        setKey(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value5(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value6(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value7(Integer value) {
        setSort(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value8(SysDictStatus value) {
        setStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value9(Timestamp value) {
        setCreateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value10(Timestamp value) {
        setUpdateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value11(String value) {
        setRemarks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value12(Boolean value) {
        setDelFlag(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord value13(Long value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysDictRecord values(Long value1, String value2, String value3, String value4, String value5, String value6, Integer value7, SysDictStatus value8, Timestamp value9, Timestamp value10, String value11, Boolean value12, Long value13) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SysDictRecord
     */
    public SysDictRecord() {
        super(SysDict.SYS_DICT);
    }

    /**
     * Create a detached, initialised SysDictRecord
     */
    public SysDictRecord(Long id, String label, String groupName, String key, String value, String description, Integer sort, SysDictStatus status, Timestamp createAt, Timestamp updateAt, String remarks, Boolean delFlag, Long version) {
        super(SysDict.SYS_DICT);

        set(0, id);
        set(1, label);
        set(2, groupName);
        set(3, key);
        set(4, value);
        set(5, description);
        set(6, sort);
        set(7, status);
        set(8, createAt);
        set(9, updateAt);
        set(10, remarks);
        set(11, delFlag);
        set(12, version);
    }
}
