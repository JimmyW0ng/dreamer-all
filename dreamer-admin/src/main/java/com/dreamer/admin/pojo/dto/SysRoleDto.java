package com.dreamer.admin.pojo.dto;

import com.dreamer.pojo.AbstractBasePojo;
import com.dreamer.pojo.po.SysRolePojo;
import lombok.Data;

import java.util.List;

/**
 * Created by JW on 17/8/29.
 */
@Data
public class SysRoleDto extends AbstractBasePojo {

    private SysRolePojo sysRolePojo;

    private List<Long> menuIds;
}
