/*
 * This file is generated by jOOQ.
*/
package com.dreamer.pojo.po;


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

    public SysUserRolePojo() {
    }

    public SysUserRolePojo(SysUserRolePojo value) {
        this.id = value.id;
        this.sysUserId = value.sysUserId;
        this.sysRoleId = value.sysRoleId;
    }

    public SysUserRolePojo(
            Long id,
            Long sysUserId,
            Long sysRoleId
    ) {
        this.id = id;
        this.sysUserId = sysUserId;
        this.sysRoleId = sysRoleId;
    }

    public Long getId() {
        return this.id;
    }

    public SysUserRolePojo setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getSysUserId() {
        return this.sysUserId;
    }

    public SysUserRolePojo setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
        return this;
    }

    public Long getSysRoleId() {
        return this.sysRoleId;
    }

    public SysUserRolePojo setSysRoleId(Long sysRoleId) {
        this.sysRoleId = sysRoleId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SysUserRolePojo (");

        sb.append(id);
        sb.append(", ").append(sysUserId);
        sb.append(", ").append(sysRoleId);

        sb.append(")");
        return sb.toString();
    }

}