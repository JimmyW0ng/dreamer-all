package com.dreamer.admin.service;

import com.dreamer.admin.pojo.po.SysRoleMenuPojo;
import com.dreamer.admin.pojo.po.SysRolePojo;
import com.dreamer.admin.repository.SysRoleMenuRepository;
import com.dreamer.admin.repository.SysRoleRepository;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.common.tool.DateTools;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static com.dreamer.admin.domain.Tables.SYS_ROLE;

/**
 * Created by jw on 2017/1/13 0013.
 */
@Slf4j
@Service
public class SysRoleService {
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;

    //按条件查询并分页
    public Page<SysRolePojo> findbyPageAndCondition(Pageable pageable, Collection<? extends Condition> condition) {
        return sysRoleRepository.findByPageable(pageable, condition);
    }

    public SysRolePojo findById(Long id) {
        return sysRoleRepository.fetchOne(SYS_ROLE.ID, id);

    }

    public List<SysRolePojo> findAll() {
        return sysRoleRepository.fetchList(SYS_ROLE.DEL_FLAG, false);

    }

    public Map<String, Object> findRoleMenuById(Long id) {
        Map<String, Object> map = Maps.newHashMap();
        SysRolePojo sysRolePojo = sysRoleRepository.fetchOne(SYS_ROLE.ID, id);
        map.put("sysRolePojo", sysRolePojo);

        List<SysRoleMenuPojo> SysRoleMenuPojos = sysRoleMenuRepository.findByRoleId(id);
        List<Long> menuIds = new ArrayList<Long>();
        if (CollectionsTools.isNotEmpty(SysRoleMenuPojos)) {
            for (SysRoleMenuPojo p : SysRoleMenuPojos) {
                menuIds.add(p.getSysMenuId());
            }
        }

        map.put("menuIds", menuIds);
        return map;

    }

    //根据ID物理删除
    public void deleteByIdPhysical(Long id) {
        sysRoleRepository.deleteById(id);
    }

    //@CacheEvict(value = "SysMenuPojo", allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdLogical(Long id) {
        sysRoleRepository.deleteByIdLogical(id);
        sysRoleMenuRepository.deleteByRoleId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertSysRolePojo(SysRolePojo sysRolePojo, List<Long> menuIds) throws Exception {
//        sysRoleDto.setCreateAt(DateTools.getCurrentDateTime());
//        List<Long> menuIds = sysRoleDto.getMenuIds();
//        SysRolePojo sysRolePojo = (SysRolePojo) sysRoleDto;
        sysRolePojo.setCreateAt(DateTools.getCurrentDateTime());
        sysRolePojo.setDelFlag(false);
        Long roleId = sysRoleRepository.create(sysRolePojo).getId();
        if (CollectionsTools.isNotEmpty(menuIds)) {
            for (Long id : menuIds) {
                SysRoleMenuPojo sysRoleMenuPojo = new SysRoleMenuPojo();
                sysRoleMenuPojo.setSysRoleId(roleId);
                sysRoleMenuPojo.setSysMenuId(id);
                sysRoleMenuRepository.create(sysRoleMenuPojo);
            }
        }

    }

    //    @CacheEvict(value = "SysMenuPojo" ,allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void updateSysRolePojo(Long id, SysRolePojo sysRolePojo, List<Long> menuIds) throws Exception {
        sysRolePojo.setUpdateAt(DateTools.getCurrentDateTime());
        sysRoleRepository.update(sysRolePojo);

        List<SysRoleMenuPojo> sysRoleMenus = sysRoleMenuRepository.findByRoleId(id);
        Set<Long> menuOldSet = new HashSet<Long>();
        for (SysRoleMenuPojo sysRoleMenu : sysRoleMenus) {
            menuOldSet.add(sysRoleMenu.getSysMenuId());
        }
        Set<Long> menuNewSet = new HashSet<Long>();
        if (CollectionsTools.isNotEmpty(menuIds)) {
            for (Long menuId : menuIds) {
                menuNewSet.add(menuId);
            }
            Set<Long> diffAdd = Sets.difference(menuNewSet, menuOldSet);//差集，menuNewSet有, menuOldSet无
            Set<Long> diffDel = Sets.difference(menuOldSet, menuNewSet);
            for (Long menuId : diffDel) {
                sysRoleMenuRepository.deleteByRoleIdAndMenuId(id, menuId);
            }

            for (Long menuId : diffAdd) {
                SysRoleMenuPojo sysRoleMenuPojo = new SysRoleMenuPojo();
                sysRoleMenuPojo.setSysMenuId(menuId);
                sysRoleMenuPojo.setSysRoleId(id);
                sysRoleMenuRepository.create(sysRoleMenuPojo);
            }
        }
        log.info("[系统设置],角色更新成功。roleId={};oldMenuIds={};newMenuIds={}。", sysRolePojo.getId(), menuOldSet.toString(), menuNewSet.toString());

    }
}