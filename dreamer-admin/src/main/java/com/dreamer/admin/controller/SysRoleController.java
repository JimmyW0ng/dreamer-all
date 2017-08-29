package com.dreamer.admin.controller;

import com.dreamer.admin.core.constant.Constant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.dto.SysMenuDto;
import com.dreamer.admin.pojo.dto.SysRoleDto;
import com.dreamer.business.service.SysMenuService;
import com.dreamer.business.service.SysRoleService;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.common.tool.StringTools;
import com.dreamer.pojo.po.SysMenuPojo;
import com.dreamer.pojo.po.SysRolePojo;
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
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.dreamer.domain.Tables.SYS_ROLE;

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
        model.addAttribute("menuTree", SysMenuController.buildMenuList(Constant.ADMIN_MENU_HEAD_ID, sysMenuService.findAll()));
        return PAGE_URL_PREFIX + MODULE_PREFIX + "form";
    }

}
