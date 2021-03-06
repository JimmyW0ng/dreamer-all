/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables.records;


import com.dreamer.admin.domain.tables.CstCourseCatalog;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class CstCourseCatalogRecord extends UpdatableRecordImpl<CstCourseCatalogRecord> implements Record8<Long, Long, String, Timestamp, Timestamp, String, Boolean, Long> {

    private static final long serialVersionUID = 590361911;

    /**
     * Create a detached CstCourseCatalogRecord
     */
    public CstCourseCatalogRecord() {
        super(CstCourseCatalog.CST_COURSE_CATALOG);
    }

    /**
     * Create a detached, initialised CstCourseCatalogRecord
     */
    public CstCourseCatalogRecord(Long id, Long parentId, String label, Timestamp createAt, Timestamp updateAt, String remark, Boolean delFlag, Long version) {
        super(CstCourseCatalog.CST_COURSE_CATALOG);

        set(0, id);
        set(1, parentId);
        set(2, label);
        set(3, createAt);
        set(4, updateAt);
        set(5, remark);
        set(6, delFlag);
        set(7, version);
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.id</code>. 主键
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.id</code>. 主键
     */
    public CstCourseCatalogRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.parent_id</code>. 父级id
     */
    public Long getParentId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.parent_id</code>. 父级id
     */
    public CstCourseCatalogRecord setParentId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.label</code>. 标签
     */
    public String getLabel() {
        return (String) get(2);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.label</code>. 标签
     */
    public CstCourseCatalogRecord setLabel(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.create_at</code>. 创建时间
     */
    public Timestamp getCreateAt() {
        return (Timestamp) get(3);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.create_at</code>. 创建时间
     */
    public CstCourseCatalogRecord setCreateAt(Timestamp value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.update_at</code>. 更新时间
     */
    public Timestamp getUpdateAt() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.update_at</code>. 更新时间
     */
    public CstCourseCatalogRecord setUpdateAt(Timestamp value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.remark</code>. 备注信息
     */
    public String getRemark() {
        return (String) get(5);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.remark</code>. 备注信息
     */
    public CstCourseCatalogRecord setRemark(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.cst_course_catalog.del_flag</code>. 删除标志
     */
    public Boolean getDelFlag() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>dreamer.cst_course_catalog.del_flag</code>. 删除标志
     */
    public CstCourseCatalogRecord setDelFlag(Boolean value) {
        set(6, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>dreamer.cst_course_catalog.version</code>.
     */
    public Long getVersion() {
        return (Long) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>dreamer.cst_course_catalog.version</code>.
     */
    public CstCourseCatalogRecord setVersion(Long value) {
        set(7, value);
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
    public Row8<Long, Long, String, Timestamp, Timestamp, String, Boolean, Long> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Long, Long, String, Timestamp, Timestamp, String, Boolean, Long> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return CstCourseCatalog.CST_COURSE_CATALOG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return CstCourseCatalog.CST_COURSE_CATALOG.PARENT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return CstCourseCatalog.CST_COURSE_CATALOG.LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field4() {
        return CstCourseCatalog.CST_COURSE_CATALOG.CREATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return CstCourseCatalog.CST_COURSE_CATALOG.UPDATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return CstCourseCatalog.CST_COURSE_CATALOG.REMARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return CstCourseCatalog.CST_COURSE_CATALOG.DEL_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return CstCourseCatalog.CST_COURSE_CATALOG.VERSION;
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
    public Long value2() {
        return getParentId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getLabel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value4() {
        return getCreateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getUpdateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getRemark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value2(Long value) {
        setParentId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value3(String value) {
        setLabel(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value4(Timestamp value) {
        setCreateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value5(Timestamp value) {
        setUpdateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value6(String value) {
        setRemark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value7(Boolean value) {
        setDelFlag(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord value8(Long value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CstCourseCatalogRecord values(Long value1, Long value2, String value3, Timestamp value4, Timestamp value5, String value6, Boolean value7, Long value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }
}
