package com.dreamer.admin.service;

import com.dreamer.admin.pojo.po.SysMenuPojo;
import com.dreamer.admin.repository.SysRoleMenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by jw on 2016/12/10.
 */
@Slf4j
@Service
public class SysRoleMenuService {
    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    public List<SysMenuPojo> getSysRoleMenusByRoleId(Long roleId, Collection<Condition> conditions) {
        return sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, conditions);

    }
}
