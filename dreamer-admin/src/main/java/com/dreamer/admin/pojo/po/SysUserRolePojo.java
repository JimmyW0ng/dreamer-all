/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.pojo.po;


import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;


/**
 * 用户-角色
 */
@Data
public class SysUserRolePojo extends AbstractBasePojo {

    private static final long serialVersionUID = -608624584;

    private Long id;
    private Long sysUserId;
    private Long sysRoleId;

}
