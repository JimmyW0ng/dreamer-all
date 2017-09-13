/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables.records;


import com.dreamer.admin.domain.tables.SysRoleMenu;
import org.jooq.Field;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


/**
 * 角色-菜单
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SysRoleMenuRecord extends UpdatableRecordImpl<SysRoleMenuRecord> implements Record3<Long, Long, Long> {

    private static final long serialVersionUID = 1094480400;

    /**
     * Create a detached SysRoleMenuRecord
     */
    public SysRoleMenuRecord() {
        super(SysRoleMenu.SYS_ROLE_MENU);
    }

    /**
     * Create a detached, initialised SysRoleMenuRecord
     */
    public SysRoleMenuRecord(Long id, Long sysRoleId, Long sysMenuId) {
        super(SysRoleMenu.SYS_ROLE_MENU);

        set(0, id);
        set(1, sysRoleId);
        set(2, sysMenuId);
    }

    /**
     * Getter for <code>dreamer.sys_role_menu.id</code>.
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>dreamer.sys_role_menu.id</code>.
     */
    public SysRoleMenuRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.sys_role_menu.sys_role_id</code>. 角色编号
     */
    public Long getSysRoleId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>dreamer.sys_role_menu.sys_role_id</code>. 角色编号
     */
    public SysRoleMenuRecord setSysRoleId(Long value) {
        set(1, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>dreamer.sys_role_menu.sys_menu_id</code>. 菜单编号
     */
    public Long getSysMenuId() {
        return (Long) get(2);
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>dreamer.sys_role_menu.sys_menu_id</code>. 菜单编号
     */
    public SysRoleMenuRecord setSysMenuId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record3<Long, Long, Long> key() {
        return (Record3) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Long, Long, Long> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return SysRoleMenu.SYS_ROLE_MENU.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return SysRoleMenu.SYS_ROLE_MENU.SYS_ROLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return SysRoleMenu.SYS_ROLE_MENU.SYS_MENU_ID;
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
        return getSysRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getSysMenuId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenuRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenuRecord value2(Long value) {
        setSysRoleId(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenuRecord value3(Long value) {
        setSysMenuId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenuRecord values(Long value1, Long value2, Long value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }
}
