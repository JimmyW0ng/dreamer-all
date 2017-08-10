package com.dreamer.admin.core.realm;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by J.W on 2017/8/9 0009.
 */
@Slf4j
public class SysUserRealm extends AuthorizingRealm {

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String currentUsername = (String) super.getAvailablePrincipal(principalCollection);
        SysUserPojo user = SpringUtil.getBean(SysUserService.class).findByLoginName(currentUsername);
        List<SysMenuPojo> sysMenuPojoBySyserId = SpringUtil.getBean(SysMenuService.class)
                                                           .findSysMenuPojoBySyserId(user.getId());
        List<String> permissionList = Collections3.extractToList(sysMenuPojoBySyserId, "permission");
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
        SysUserPojo user = SpringUtil.getBean(SysUserService.class).findByLoginName(userName);
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        if (user.getStatus().equals(SysUserStatus.disabled)) {
            throw new UnknownAccountException("当前用户不可用！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), getName());

        return info;
    }
}
