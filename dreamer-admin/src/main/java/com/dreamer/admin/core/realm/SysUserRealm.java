package com.dreamer.admin.core.realm;

import com.dreamer.business.service.SysMenuService;
import com.dreamer.business.service.SysUserService;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.domain.enums.SysUserStatus;
import com.dreamer.pojo.po.SysMenuPojo;
import com.dreamer.pojo.po.SysUserPojo;
import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by J.W on 2017/8/9 0009.
 */
public class SysUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentUsername = (String) super.getAvailablePrincipal(principalCollection);
        SysUserPojo user = sysUserService.findByLoginName(currentUsername);
        List<SysMenuPojo> sysMenuPojoBySyserId = sysMenuService.findSysMenuPojoBySyserId(user.getId());
        List<String> permissionList = CollectionsTools.extractToList(sysMenuPojoBySyserId, "permission");
        List<String> roleList = Lists.newArrayList();
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);
        simpleAuthorInfo.addStringPermissions(permissionList);
        return simpleAuthorInfo;
    }

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String userName = upt.getUsername();
        SysUserPojo user = sysUserService.findByLoginName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        if (user.getStatus().equals(SysUserStatus.disabled)) {
            throw new UnknownAccountException("当前用户不可用！");
        }
        return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());
    }
}
