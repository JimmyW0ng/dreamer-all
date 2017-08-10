/*
 * This file is generated by jOOQ.
*/
package com.dreamer.domain.tables;


import com.dreamer.domain.Jw;
import com.dreamer.domain.Keys;
import com.dreamer.domain.tables.records.SysRoleMenuRecord;

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
public class SysRoleMenu extends TableImpl<SysRoleMenuRecord> {

    private static final long serialVersionUID = -1007640234;

    /**
     * The reference instance of <code>jw.sys_role_menu</code>
     */
    public static final SysRoleMenu SYS_ROLE_MENU = new SysRoleMenu();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SysRoleMenuRecord> getRecordType() {
        return SysRoleMenuRecord.class;
    }

    /**
     * The column <code>jw.sys_role_menu.id</code>.
     */
    public final TableField<SysRoleMenuRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>jw.sys_role_menu.sys_role_id</code>. 角色编号
     */
    public final TableField<SysRoleMenuRecord, Long> SYS_ROLE_ID = createField("sys_role_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "角色编号");

    /**
     * The column <code>jw.sys_role_menu.sys_menu_id</code>. 菜单编号
     */
    public final TableField<SysRoleMenuRecord, Long> SYS_MENU_ID = createField("sys_menu_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "菜单编号");

    /**
     * Create a <code>jw.sys_role_menu</code> table reference
     */
    public SysRoleMenu() {
        this("sys_role_menu", null);
    }

    /**
     * Create an aliased <code>jw.sys_role_menu</code> table reference
     */
    public SysRoleMenu(String alias) {
        this(alias, SYS_ROLE_MENU);
    }

    private SysRoleMenu(String alias, Table<SysRoleMenuRecord> aliased) {
        this(alias, aliased, null);
    }

    private SysRoleMenu(String alias, Table<SysRoleMenuRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "角色-菜单");
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
    public Identity<SysRoleMenuRecord, Long> getIdentity() {
        return Keys.IDENTITY_SYS_ROLE_MENU;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<SysRoleMenuRecord> getPrimaryKey() {
        return Keys.KEY_SYS_ROLE_MENU_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<SysRoleMenuRecord>> getKeys() {
        return Arrays.<UniqueKey<SysRoleMenuRecord>>asList(Keys.KEY_SYS_ROLE_MENU_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SysRoleMenu as(String alias) {
        return new SysRoleMenu(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SysRoleMenu rename(String name) {
        return new SysRoleMenu(name, null);
    }
}