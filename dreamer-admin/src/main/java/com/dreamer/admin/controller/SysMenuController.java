package com.dreamer.admin.controller;

import com.dreamer.admin.core.constant.Constant;
import com.dreamer.admin.pojo.dto.SysMenuDto;
import com.dreamer.business.service.SysMenuService;
import com.dreamer.pojo.po.SysMenuPojo;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 菜单管理
 * <p>
 * Created by J.W on 2017/8/21 0021.
 */
@Controller
@RequestMapping("sysMenu")
@Slf4j
public class SysMenuController extends BaseController {

    private static final String MODULE_PREFIX = "sysMenu/";

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 菜单列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("sysMenu:index")
    public String index(Model model) {
        List<SysMenuPojo> allMenus = sysMenuService.findAll();
        model.addAttribute("menuTree", buildMenuMap(allMenus));
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    /**
     * 生成菜单树状结构
     *
     * @param allMenus
     * @return
     */
    private SysMenuDto buildMenuMap(List<SysMenuPojo> allMenus) {
        SysMenuDto sysMenuDto = new SysMenuDto();
        Optional<SysMenuPojo> optOfHead = allMenus.stream().filter(item -> item.getId().equals(Constant.ADMIN_MENU_HEAD_ID)).findFirst();
        if (!optOfHead.isPresent()) {
            sysMenuDto.setHasChild(true);
            return sysMenuDto;
        }
        SysMenuPojo sysMenuPojo = optOfHead.get();
        sysMenuDto.setName(sysMenuPojo.getName());
        sysMenuDto.setHref(sysMenuPojo.getHref());
        allMenus.remove(sysMenuPojo);
        Map<Long, SysMenuDto> subMenuMap = buidSubMenuMap(sysMenuPojo.getId(), allMenus);
        if (subMenuMap.isEmpty()) {
            sysMenuDto.setHasChild(false);
        } else {
            sysMenuDto.setHasChild(true);
            sysMenuDto.setSysMenuDtoMap(subMenuMap);
        }
        return sysMenuDto;
    }

    private Map<Long, SysMenuDto> buidSubMenuMap(Long parentId, List<SysMenuPojo> allMenus) {
        Map<Long, SysMenuDto> subMenuMap = Maps.newTreeMap();
        Long index = 0L;
        for (int i = 0; i < allMenus.size(); i++) {
            SysMenuPojo sysMenuPojo = allMenus.get(i);
            if (!sysMenuPojo.getParentId().equals(parentId)) {
                continue;
            }
            index++;
            SysMenuDto sysMenuDto = new SysMenuDto();
            sysMenuDto.setName(sysMenuPojo.getName());
            sysMenuDto.setHref(sysMenuPojo.getHref());
            allMenus.remove(sysMenuPojo);
            Map<Long, SysMenuDto> leafMap = buidSubMenuMap(sysMenuPojo.getId(), allMenus);
            if (leafMap.isEmpty()) {
                sysMenuDto.setHasChild(false);
            } else {
                sysMenuDto.setHasChild(true);
                sysMenuDto.setSysMenuDtoMap(leafMap);
            }
            subMenuMap.put(index, sysMenuDto);
        }
        return subMenuMap;
    }
}
