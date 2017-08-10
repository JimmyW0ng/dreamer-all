package com.dreamer.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by J.W on 2017/8/8 0008.
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login.html";
    }

//    /**
//     * 跳转到主页
//     */
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Model model) {
//        //获取菜单列表
//        List<Integer> roleList = ShiroKit.getUser().getRoleList();
//        if (roleList == null || roleList.size() == 0) {
//            ShiroKit.getSubject().logout();
//            model.addAttribute("tips", "该用户没有角色，无法登陆");
//            return "/login.html";
//        }
//        List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
//        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        model.addAttribute("titles", titles);
//
//        //获取用户头像
//        Integer id = ShiroKit.getUser().getId();
//        User user = userMapper.selectById(id);
//        String avatar = user.getAvatar();
//        model.addAttribute("avatar", avatar);
//
//        return "/index.html";
//    }
}
