package com.dreamer.business.service;


import com.dreamer.business.repository.SysUserRepository;
import com.dreamer.business.repository.SysUserRoleRepository;
import com.dreamer.common.tool.BeanTools;
import com.dreamer.common.tool.DateTools;
import com.dreamer.domain.enums.SysUserStatus;
import com.dreamer.pojo.po.SysUserPojo;
import com.dreamer.pojo.po.SysUserRolePojo;
import com.google.common.collect.Sets;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.dreamer.domain.Tables.SYS_USER_ROLE;

/**
 * Created by jw on 2016/12/12.
 */
@Service
public class SysUserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;

    public SysUserPojo findById(Long id) {
        return sysUserRepository.getById(id);
    }

    public SysUserPojo findByLoginName(String loginName) {
        return sysUserRepository.findByLoginName(loginName);
    }

    @Transactional(rollbackFor = Exception.class)
    public Long insert(SysUserPojo pojo, List<Long> roleIds) throws Exception {
        pojo.setStatus(SysUserStatus.enable);
        pojo.setCreateAt(DateTools.getCurrentDateTime());
        pojo.setDelFlag(false);
        Long userId = sysUserRepository.create(pojo).getId();
        if (null != roleIds) {
            for (Long roleId : roleIds) {
                sysUserRoleRepository.create(new SysUserRolePojo(null, userId, new Long((long) roleId)));
            }
        }
        return userId;
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Long id, SysUserPojo pojo, List<Long> roleIds) throws Exception {
        pojo.setUpdateAt(DateTools.getCurrentDateTime());
        sysUserRepository.update(pojo);

        List<SysUserRolePojo> sysUserRoles = sysUserRoleRepository.findByUserId(id);
        Set<Long> menuOldSet = new HashSet<Long>();
        for (SysUserRolePojo sysUserRole : sysUserRoles) {
            menuOldSet.add(sysUserRole.getSysRoleId());
        }
        Set<Long> menuNewSet = new HashSet<Long>();
        if (null != roleIds) {
            for (Long roleId : roleIds) {
                menuNewSet.add(roleId);
            }
        }
        Set<Long> diffAdd = Sets.difference(menuNewSet, menuOldSet);
        Set<Long> diffDel = Sets.difference(menuOldSet, menuNewSet);
        for (Long roleId : diffDel) {
            sysUserRoleRepository.deleteByUserIdAndRoleId(id, roleId);
        }

        for (Long roleId : diffAdd) {
            SysUserRolePojo sysUserRolePojo = new SysUserRolePojo();
            sysUserRolePojo.setSysRoleId(roleId);
            sysUserRolePojo.setSysUserId(id);
            sysUserRoleRepository.create(sysUserRolePojo);
        }

    }

    public void settingSave(SysUserPojo sysUserPojo) throws Exception {
        SysUserPojo sysUserPojoTar = this.findById(sysUserPojo.getId());
        BeanTools.copyPropertiesIgnoreNull(sysUserPojo, sysUserPojoTar);
        sysUserPojoTar.setUpdateAt(DateTools.getCurrentDateTime());
        sysUserRepository.update(sysUserPojoTar);
    }

    public Page<SysUserPojo> findbyPageAndCondition(Pageable pageable, Collection<? extends Condition> condition) {
        return sysUserRepository.findByPageable(pageable, condition);
    }

    public Page<SysUserPojo> findbyPageable(Pageable pageable, Map<String, Object> filterQuery) {
        return sysUserRepository.findByPageable(pageable, filterQuery);
    }

    public Page<SysUserPojo> findbyPageable(Pageable pageable) {
        Map map = new HashMap<>();
        return sysUserRepository.findByPageable(pageable, map);
    }

    public List<Long> findRoleByUserId(Long userId) {
        List<Long> roleIds = new ArrayList<Long>();
        List<SysUserRolePojo> sysUserRolePojos = sysUserRoleRepository.fetchList(SYS_USER_ROLE.SYS_USER_ID, userId);
        if (null != sysUserRolePojos && sysUserRolePojos.size() > 0) {
            for (SysUserRolePojo pojo : sysUserRolePojos) {
                roleIds.add(pojo.getSysRoleId());
            }
        }
        return roleIds;
    }

    public int deleteByIdLogical(Long userId) {
        return sysUserRepository.deleteByIdLogical(userId);
    }
}