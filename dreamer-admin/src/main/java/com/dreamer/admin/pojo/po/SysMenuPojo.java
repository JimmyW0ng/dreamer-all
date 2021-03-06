/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.pojo.po;


import com.dreamer.admin.domain.enums.SysMenuStatus;
import com.dreamer.admin.domain.enums.SysMenuType;
import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.List;


/**
 * 菜单表
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.4"
        },
        comments = "This class is generated by jOOQ"
)
@Data
public class SysMenuPojo extends AbstractBasePojo {

    private static final long serialVersionUID = -466337487;

    private Long id;
    private Long parentId;
    private SysMenuType type;
    private String name;
    private String href;
    private String target;
    private String icon;
    private Integer sort;
    private SysMenuStatus status;
    private String permission;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String remark;
    private Boolean delFlag;
    private Long version;

    private List<SysMenuPojo> list;

}
