package com.dreamer.admin.controller;

import com.dreamer.business.service.SysUserService;
import com.dreamer.pojo.po.SysUserPojo;
import com.google.common.collect.Lists;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

import static com.dreamer.domain.Tables.SYS_USER;

/**
 * 用户管理
 * Created by JW on 17/Ø8/15.
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseBackendController {

    private static final String MODULE_PREFIX = "sysUser/";

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户查询列表
     */
    @GetMapping(value = "/index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("sysUser:index")
    public String index(Model model,
                        @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Collection<Condition> collections = Lists.newArrayList();
        collections.add(SYS_USER.DEL_FLAG.eq(false));
        Page<SysUserPojo> page = sysUserService.findbyPageAndCondition(pageable, collections);
        model.addAttribute("page", page);
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }
}
