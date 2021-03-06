package com.dreamer.admin.controller;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.dto.SysMenuDto;
import com.dreamer.admin.pojo.dto.SysRoleDto;
import com.dreamer.admin.pojo.po.SysMenuPojo;
import com.dreamer.admin.pojo.po.SysRolePojo;
import com.dreamer.admin.service.SysMenuService;
import com.dreamer.admin.service.SysRoleService;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.common.tool.StringTools;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.dreamer.admin.domain.Tables.SYS_ROLE;

/**
 * 角色管理
 *
 * Created by J.W on 2017/8/21 0021.
 */
@Controller
@RequestMapping("sysRole")
@Slf4j
public class SysRoleController extends BaseController {

    private static final String MODULE_PREFIX = "sysRole/";

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 生成菜单树状结构
     *
     * @param allMenus
     * @return
     */
    public static SysMenuDto buildMenuList(Long parentId, List<SysMenuPojo> allMenus, List<Long> roleMenus) {
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
     * 角色列表
     *
     * @param model
     * @param pageable
     * @param name
     */
    @RequestMapping("index")
    @RequiresPermissions("sysRole:index")
    public String index(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam(value = "name", required = false) String name) {

        Collection<Condition> collections = Lists.newArrayList();
        collections.add(SYS_ROLE.DEL_FLAG.eq(false));
        if (StringTools.isNotBlank(name)) {
            Condition condition = SYS_ROLE.NAME.like("%" + name + "%");
            collections.add(condition);
        }
        Page<SysRolePojo> page = sysRoleService.findbyPageAndCondition(pageable, collections);
        model.addAttribute("page", page);
        model.addAttribute("name", name);
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    @RequestMapping("toForm")
    @RequiresPermissions("sysRole:index")
    public String index(Model model,
                        @RequestParam(value = "id", required = false) Long id,
                        @RequestParam(value = "method", required = true) String method) {
        if ("info".equals(method) || "edit".equals(method)) {
            Map<String, Object> map = sysRoleService.findRoleMenuById(id);
            SysRolePojo sysRolePojo = (SysRolePojo) map.get("sysRolePojo");
            SysRoleDto sysRoleDto = new SysRoleDto();
            List<Long> menuIds = (List<Long>) map.get("menuIds");
            sysRoleDto.setSysRolePojo(sysRolePojo);
            sysRoleDto.setMenuIds(menuIds);
            model.addAttribute("sysRoleDto", sysRoleDto);
        } else {
            model.addAttribute("sysRoleDto", new SysRoleDto());
        }
        model.addAttribute("method", method);
        model.addAttribute("menuTree", buildMenuList(Constant.ADMIN_MENU_HEAD_ID, sysMenuService.findAll(), null));
        return PAGE_URL_PREFIX + MODULE_PREFIX + "form";
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("sysUser:maintenance")
    @ResponseBody
    public ResultDo delete(@RequestParam(value = "id", required = true) Long id) {
        sysRoleService.deleteByIdLogical(id);
        return ResultDo.build();
    }
}
