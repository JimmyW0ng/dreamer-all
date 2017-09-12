/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.pojo.po;


import com.dreamer.admin.domain.enums.SysDictStatus;
import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;

import java.sql.Timestamp;


/**
 * 字典表
 */
@Data
public class SysDictPojo extends AbstractBasePojo {

    private static final long serialVersionUID = -494057948;

    private Long id;
    private String label;
    private String groupName;
    private String key;
    private String value;
    private String description;
    private Integer sort;
    private SysDictStatus status;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String remarks;
    private Boolean delFlag;
    private Long version;

}