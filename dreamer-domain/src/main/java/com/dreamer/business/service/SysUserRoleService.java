package com.dreamer.business.service;

import com.dreamer.business.repository.SysUserRoleRepository;
import com.dreamer.pojo.po.SysUserRolePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jw on 2017/1/13 0013.
 */
@Slf4j
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    public SysUserRolePojo getSysUserRolePojoByUserId(Long userId) {
        return sysUserRoleRepository.findByUserId(userId).get(0);
    }

    public Long insert(Long userId, Long roleId) {
        sysUserRoleRepository.deleteByUserId(userId);
        SysUserRolePojo sysUserRolePojo = new SysUserRolePojo();
        sysUserRolePojo.setSysUserId(userId);
        sysUserRolePojo.setSysRoleId(roleId);
        sysUserRoleRepository.insert(sysUserRolePojo);
        return sysUserRolePojo.getId();
    }
}
