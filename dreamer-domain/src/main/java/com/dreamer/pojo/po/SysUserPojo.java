/*
 * This file is generated by jOOQ.
*/
package com.dreamer.pojo.po;


import com.dreamer.domain.enums.SysUserStatus;
import com.dreamer.pojo.AbstractBasePojo;
import lombok.Data;

import java.sql.Timestamp;


/**
 * 用户表
 */
@Data
public class SysUserPojo extends AbstractBasePojo {

    private static final long serialVersionUID = -487729196;

    private Long id;
    private String loginName;
    private String password;
    private String no;
    private String name;
    private String email;
    private String phone;
    private String mobile;
    private SysUserStatus status;
    private String loginIp;
    private Timestamp loginTime;
    private String avatars;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String remarks;
    private Boolean delFlag;

}
