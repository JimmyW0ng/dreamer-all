package com.dreamer.admin.controller;

import com.dreamer.admin.pojo.dto.SysMenuDto;
import com.dreamer.business.service.SysMenuService;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.constant.Constant;
import com.dreamer.pojo.ResultDo;
import com.dreamer.pojo.po.SysMenuPojo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     * 生成菜单树状结构
     *
     * @param allMenus
     * @return
     */
    public static SysMenuDto buildMenuList(Long parentId, List<SysMenuPojo> allMenus) {
        SysMenuDto sysMenuDto = new SysMenuDto();
        Optional<SysMenuPojo> optOfHead = allMenus.stream().filter(item -> item.getId().equals(parentId)).findFirst();
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
    private static List<SysMenuDto> buidSubMenuList(Long parentId, List<SysMenuPojo> allMenus) {
        List<SysMenuPojo> menus = Lists.newArrayList();
        for (SysMenuPojo sysMenuPojo : allMenus) {
            if (sysMenuPojo.getParentId().equals(parentId)) {
                menus.add(sysMenuPojo);
            }
        }
        List<SysMenuDto> subMenuList = Lists.newArrayList();
        for (SysMenuPojo sysMenuPojo : menus) {
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
        model.addAttribute("menuTree", buildMenuList(Constant.ADMIN_MENU_HEAD_ID, allMenus));
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    /**
     * 保存菜单（新增/维护）
     *
     * @param sysMenuPojo
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("sysMenu:maintenance")
    @ResponseBody
    public ResultDo save(@RequestBody SysMenuPojo sysMenuPojo) {
        if (sysMenuPojo.getId() == null) {
            sysMenuService.insert(sysMenuPojo);
        } else {
            sysMenuService.update(sysMenuPojo);
        }
        return ResultDo.build();
    }

    /**
     * 菜单详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @RequiresPermissions("sysMenu:maintenance")
    @ResponseBody
    public ResultDo info(@RequestParam(value = "id", required = true) Long id) {
        SysMenuPojo sysMenuPojo = sysMenuService.findById(id);
        return ResultDo.build().setResult(sysMenuPojo);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    @RequiresPermissions("sysMenu:maintenance")
    @ResponseBody
    public ResultDo del(@RequestParam(value = "id", required = true) Long id) {
        sysMenuService.deleteByIdLogical(id);
        return ResultDo.build();
    }
}
