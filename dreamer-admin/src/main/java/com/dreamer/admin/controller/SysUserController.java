package com.dreamer.admin.controller;

import com.dreamer.business.service.SysUserService;
import com.dreamer.common.tool.CryptTools;
import com.dreamer.common.tool.StringTools;
import com.dreamer.pojo.ResultDo;
import com.dreamer.pojo.po.SysUserPojo;
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
public class SysUserController extends BaseBackendController {

    private static final String MODULE_PREFIX = "sysUser/";

    @Autowired
    private SysUserService sysUserService;

    /**
     * 用户查询列表
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("sysUser:index")
    public String index(Model model,
                        @RequestParam(value = "loginName", required = false) String loginName,
                        @RequestParam(value = "userName", required = false) String userName,
                        @RequestParam(value = "tips", required = false) String tips,
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
        model.addAttribute("tips", tips);
        return PAGE_URL_PREFIX + MODULE_PREFIX + "index";
    }

    /**
     * 新增用户
     *
     * @param model
     * @param inputParam
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultDo add(Model model, @RequestBody SysUserPojo inputParam) {
        ResultDo<?> resultDo = ResultDo.build();
        inputParam.setPassword(CryptTools.encryptByase(inputParam.getPassword()));
        try {
            Long id = sysUserService.insert(inputParam);
            log.info("[用户管理]，新增用户成功。ID={}。", id);
        } catch (Exception e) {
            log.error("[用户管理]，新增用户失败。", e);
        }
        return resultDo;
    }
}
