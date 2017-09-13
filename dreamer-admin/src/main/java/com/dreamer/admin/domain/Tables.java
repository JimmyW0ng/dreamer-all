/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain;


import com.dreamer.admin.domain.tables.*;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in dreamer
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 字典表
     */
    public static final SysDict SYS_DICT = com.dreamer.admin.domain.tables.SysDict.SYS_DICT;

    /**
     * 日志表
     */
    public static final SysLog SYS_LOG = com.dreamer.admin.domain.tables.SysLog.SYS_LOG;

    /**
     * 菜单表
     */
    public static final SysMenu SYS_MENU = com.dreamer.admin.domain.tables.SysMenu.SYS_MENU;

    /**
     * 角色表
     */
    public static final SysRole SYS_ROLE = com.dreamer.admin.domain.tables.SysRole.SYS_ROLE;

    /**
     * 角色-菜单
     */
    public static final SysRoleMenu SYS_ROLE_MENU = com.dreamer.admin.domain.tables.SysRoleMenu.SYS_ROLE_MENU;

    /**
     * 用户表
     */
    public static final SysUser SYS_USER = com.dreamer.admin.domain.tables.SysUser.SYS_USER;

    /**
     * 用户-角色
     */
    public static final SysUserRole SYS_USER_ROLE = com.dreamer.admin.domain.tables.SysUserRole.SYS_USER_ROLE;
}
