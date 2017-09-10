package com.dreamer.admin.pojo.dto;

import com.dreamer.admin.pojo.AbstractBasePojo;
import com.dreamer.admin.pojo.po.SysUserPojo;
import lombok.Data;

/**
 * Created by J.W on 2017/8/21 0021.
 */
@Data
public class SysUserDto extends AbstractBasePojo {

    private SysUserPojo sysUserPojo;

    private Long roleId;

}
