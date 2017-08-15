package com.dreamer.pojo.vo;

import com.dreamer.pojo.AbstractBasePojo;
import com.dreamer.pojo.po.SysMenuPojo;
import lombok.Data;

import java.util.List;

/**
 * Created by J.W on 2017/8/14 0014.
 */
@Data
public class RoleMenuVo extends AbstractBasePojo {

    private SysMenuPojo fisrtMenu;

    private List<SysMenuPojo> subMenu;

}
