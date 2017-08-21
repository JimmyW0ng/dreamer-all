package com.dreamer.admin.controller;

import com.dreamer.admin.core.constant.MessageCodeConstant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.dto.SysUserDto;
import com.dreamer.business.service.SysRoleService;
import com.dreamer.business.service.SysUserRoleService;
import com.dreamer.business.service.SysUserService;
import com.dreamer.common.tool.CryptTools;
import com.dreamer.common.tool.StringTools;
import com.dreamer.pojo.po.SysUserPojo;
import com.dreamer.pojo.po.SysUserRolePojo;
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

import java.util.Collection;

import static com.dreamer.domain.Tables.SYS_USER;

/**
 * 用户管理
 * Created by JW on 17/Ø8/15.
 */
@Controller
@RequestMapping("sysUser")
@Slf4j
public class SysUserController extends BaseController {

    private static final String MODULE_PREFIX = "sysUser/";

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 用户查询列表
     *
     * @param model
     * @param loginName
     * @param userName
     * @param pageable
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("sysUser:index")
    public String index(Model model,
                        @RequestParam(value = "loginName", required = false) String loginName,
                        @RequestParam(value = "userName", required = false) String userName,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Collection<Condition> collections = Lists.newArrayList();
        collections.add(SYS_USER.DEL_FLAG.eq(false));
        if (StringTools.isNotBlank(loginName)) {
            collections.add(SYS_USER.LOGIN_NAME.eq(loginName));
        }
        if (StringTools.isNotBlank(userName)) {
            collections.add(SYS_USER.NAME.eq(userName));
        }
        Page<SysUserPojo> page = sysUserService.findbyPageAndCondition(pageable, collections);
        model.addAttribute("loginName", loginName);
        model.addAttribute("userName", userName);
        model.addAttribute("page", page);
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    /**
     * 用户编辑页（新增/编辑）
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/toForm", method = RequestMethod.GET)
    @RequiresPermissions("sysUser:maintenance")
    public String toForm(Model model,
                         @RequestParam(value = "id", required = false) Long id) {
        SysUserPojo sysUser;
        if (id != null && id > 0L) {
            sysUser = sysUserService.findById(id);
            sysUser.setPassword(CryptTools.decryptByase(sysUser.getPassword()));
            SysUserRolePojo sysUserRolePojo = sysUserRoleService.getSysUserRolePojoByUserId(id);
            model.addAttribute("roleId", sysUserRolePojo != null ? sysUserRolePojo.getSysRoleId() : null);
        } else {
            sysUser = new SysUserPojo();
        }
        model.addAttribute("sysUser", sysUser);
        model.addAttribute("roles", sysRoleService.findAll());
        return PAGE_URL_PREFIX + MODULE_PREFIX + "form";
    }

    /**
     * 保存用户
     *
     * @param inputParam
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("sysUser:maintenance")
    @ResponseBody
    public ResultDo save(@RequestBody SysUserDto inputParam) {
        SysUserPojo sysUserPojo = inputParam.getSysUserPojo();
        sysUserPojo.setPassword(CryptTools.encryptByase(sysUserPojo.getPassword()));
        if (sysUserPojo.getId() != null && sysUserPojo.getId() > 0) {
            sysUserService.settingSave(sysUserPojo);
            sysUserRoleService.insert(sysUserPojo.getId(), inputParam.getRoleId());
        } else {
            Long userId = sysUserService.insert(sysUserPojo);
            sysUserRoleService.insert(userId, inputParam.getRoleId());
        }
        return ResultDo.build();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("sysUser:maintenance")
    @ResponseBody
    public ResultDo delete(@RequestParam(value = "id", required = true) Long id) {
        if (sysUserService.deleteByIdLogical(id) == 1) {
            return ResultDo.build();
        } else {
            return ResultDo.build(MessageCodeConstant.ERROR_SYS_USER_NOTEXIST);
        }
    }

}
