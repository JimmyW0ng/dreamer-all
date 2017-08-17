package com.dreamer.admin.controller;

import com.dreamer.admin.core.constant.Constant;
import com.dreamer.business.service.SysMenuService;
import com.dreamer.business.service.SysUserService;
import com.dreamer.common.tool.CryptTools;
import com.dreamer.pojo.po.SysUserPojo;
import com.dreamer.pojo.vo.RoleMenuVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by J.W on 2017/8/8 0008.
 */
@Controller
@Slf4j
public class LoginController extends BaseBackendController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return PAGE_URL_PREFIX + "login";
    }

    /**
     * 点击登录执行的动作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginVali(Model model,
                            @RequestParam(value = "username", required = true) String username,
                            @RequestParam(value = "password", required = true) String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, CryptTools.encryptByase(password));
        Subject currentUser = SecurityUtils.getSubject();
        String retURL = PAGE_URL_PREFIX + "index";
        try {
            log.debug("对用户[" + username + "]进行登录验证..验证开始");
            currentUser.login(token);
            log.debug("对用户[" + username + "]进行登录验证..验证通过");
            retURL = REDIRECT + "/index";
        } catch (UnknownAccountException uae) {
            log.debug("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            model.addAttribute("tips", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            log.debug("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            model.addAttribute("tips", "密码不正确");
        } catch (LockedAccountException lae) {
            log.debug("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            model.addAttribute("tips", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            log.debug("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            model.addAttribute("tips", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            // 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            log.debug("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            model.addAttribute("tips", "用户名或密码不正确");
        }
        // 验证是否登录成功
        if (currentUser.isAuthenticated()) {
            log.info("登录系统成功-" + username);
            Subject subject = SecurityUtils.getSubject();
            SysUserPojo user = sysUserService.findByLoginName(token.getUsername());
            subject.getSession().setAttribute(Constant.CURRENT_USER, user);
        } else {
            token.clear();
        }
        return retURL;
    }

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @RequiresPermissions("system:index")
    public String index(Model model) {
        SysUserPojo user = (SysUserPojo) SecurityUtils.getSubject().getSession().getAttribute(Constant.CURRENT_USER);
        SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        List<RoleMenuVo> userMenus = sysMenuService.getUserAllMenu(user.getId());
        model.addAttribute("userMenus", userMenus);
        model.addAttribute("userName", user.getName());
        return PAGE_URL_PREFIX + "index";
    }

    @RequestMapping(value = "/logout")
    public String loginOut(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return REDIRECT + "/login";
    }

    /**
     * 跳转到主页
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        return PAGE_URL_PREFIX + "home";
    }
}
