package com.dreamer.admin.pojo.dto;

import com.dreamer.pojo.AbstractBasePojo;
import lombok.Data;

import java.util.List;

/**
 * Created by J.W on 2017/8/21 0021.
 */
@Data
public class SysMenuDto extends AbstractBasePojo {

    private Boolean hasChild;

    private String name;

    private String href;

    private String sysMenuType;

    private List<SysMenuDto> sysMenuDtoList;

}
