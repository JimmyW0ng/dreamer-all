package com.dreamer.admin.controller;

import com.dreamer.admin.core.constant.Constant;
import com.dreamer.admin.pojo.dto.SysMenuDto;
import com.dreamer.business.service.SysMenuService;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.pojo.po.SysMenuPojo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
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
        model.addAttribute("menuTree", buildMenuList(allMenus));
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    /**
     * 生成菜单树状结构
     *
     * @param allMenus
     * @return
     */
    private SysMenuDto buildMenuList(List<SysMenuPojo> allMenus) {
        SysMenuDto sysMenuDto = new SysMenuDto();
        Optional<SysMenuPojo> optOfHead = allMenus.stream().filter(item -> item.getId().equals(Constant.ADMIN_MENU_HEAD_ID)).findFirst();
        if (!optOfHead.isPresent()) {
            sysMenuDto.setHasChild(true);
            return sysMenuDto;
        }
        SysMenuPojo sysMenuPojo = optOfHead.get();
        sysMenuDto.setId(sysMenuPojo.getId());
        sysMenuDto.setName(sysMenuPojo.getName());
        sysMenuDto.setHref(sysMenuPojo.getHref());
        sysMenuDto.setSysMenuType(sysMenuPojo.getType().getLiteral());
        allMenus.remove(sysMenuPojo);
        List<SysMenuDto> subMenuList = buidSubMenuList(sysMenuPojo.getId(), allMenus);
        if (CollectionsTools.isEmpty(subMenuList)) {
            sysMenuDto.setHasChild(false);
        } else {
            sysMenuDto.setHasChild(true);
            sysMenuDto.setSysMenuDtoList(subMenuList);
        }
        return sysMenuDto;
    }

    /**
     * 递归生成子菜单
     *
     * @param parentId
     * @param allMenus
     * @return
     */
    private List<SysMenuDto> buidSubMenuList(Long parentId, List<SysMenuPojo> allMenus) {
        List<SysMenuDto> subMenuList = Lists.newArrayList();
        for (int i = 0; i < allMenus.size(); i++) {
            SysMenuPojo sysMenuPojo = allMenus.get(i);
            if (!sysMenuPojo.getParentId().equals(parentId)) {
                continue;
            }
            SysMenuDto sysMenuDto = new SysMenuDto();
            sysMenuDto.setId(sysMenuPojo.getId());
            sysMenuDto.setName(sysMenuPojo.getName());
            sysMenuDto.setHref(sysMenuPojo.getHref());
            sysMenuDto.setSysMenuType(sysMenuPojo.getType().getLiteral());
            allMenus.remove(sysMenuPojo);
            List<SysMenuDto> leafList = buidSubMenuList(sysMenuPojo.getId(), allMenus);
            if (CollectionsTools.isEmpty(leafList)) {
                sysMenuDto.setHasChild(false);
            } else {
                sysMenuDto.setHasChild(true);
                sysMenuDto.setSysMenuDtoList(leafList);
            }
            subMenuList.add(sysMenuDto);
        }
        return subMenuList;
    }
}
