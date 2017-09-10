package com.dreamer.admin.pojo.dto;

import com.dreamer.admin.pojo.AbstractBasePojo;
import com.dreamer.admin.pojo.po.SysMenuPojo;
import lombok.Data;

import java.util.List;

/**
 * Created by J.W on 2017/8/14 0014.
 */
@Data
public class RoleMenuDto extends AbstractBasePojo {

    private SysMenuPojo fisrtMenu;

    private List<SysMenuPojo> subMenu;

}
