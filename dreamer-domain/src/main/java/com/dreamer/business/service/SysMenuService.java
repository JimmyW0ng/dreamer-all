package com.dreamer.business.service;

import com.dreamer.business.component.SpringComponent;
import com.dreamer.business.repository.SysMenuRepository;
import com.dreamer.business.repository.SysRoleMenuRepository;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.common.tool.StringTools;
import com.dreamer.domain.enums.SysMenuStatus;
import com.dreamer.domain.enums.SysMenuType;
import com.dreamer.pojo.po.SysMenuPojo;
import com.google.common.collect.Lists;
import org.jooq.Condition;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static com.dreamer.domain.tables.SysMenu.SYS_MENU;

/**
 * Created by jw on 2016/12/10.
 */
@Service
public class SysMenuService {

    public static String REDIS_KEY = "allchildKey";

    @Autowired
    private SysMenuRepository sysMenuDao;

    @Autowired
    private SysRoleMenuRepository sysRoleMenuRepository;


    public SysMenuPojo findById(Long id) {
        return sysMenuDao.getById(id);
    }

    private String messageSource(String code) {
        return SpringComponent.getBean(MessageSource.class).getMessage(code, null, code, null);
    }

    @CacheEvict(value = "SysMenuPojo", key = "'allchildKey'")
    @Transactional
    public SysMenuPojo insert(SysMenuPojo pojo) {
        if (pojo.getType().equals(SysMenuType.menu) && StringTools.isBlank(pojo.getIcon())) {
            pojo.setIcon(this.messageSource("sysMenuIcon.menu"));
        }
        pojo.setDelFlag(false);
        pojo.setStatus(SysMenuStatus.enable);
        return sysMenuDao.create(pojo);
    }

    @CacheEvict(value = "SysMenuPojo", key = "'allchildKey'")
    public SysMenuPojo update(SysMenuPojo pojo) {
        if (pojo.getType().equals(SysMenuType.menu) && StringTools.isBlank(pojo.getIcon())) {
            pojo.setIcon(this.messageSource("sysMenuIcon.menu"));
        }
        sysMenuDao.update(pojo);
        return pojo;
    }

    public List<SysMenuPojo> findSysMenuPojoBySyserId(Long userid) {
        return sysMenuDao.findSysMenuPojoBySyserId(userid);
    }

    public List<SysMenuPojo> findAll() {
        return sysMenuDao.findAll();
    }

    @Cacheable(value = "SysMenuPojo", key = "'allchildKey'")
    public List<SysMenuPojo> findChild() {
        return sysMenuDao.findChild();
    }

    @CacheEvict(value = "SysMenuPojo", key = "'allchildKey'")
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIdLogical(List<Long> menuIds) throws Exception {
        if (!menuIds.isEmpty()) {
            for (Long id : menuIds) {
                sysMenuDao.deleteByIdLogical(id);
                sysRoleMenuRepository.deleteByMenuId(id);
            }

        }
    }

    public String getFullMenuById(Long id) {
        Long childId = id;
        StringBuffer fullPath = new StringBuffer("");
        List<String> menuName = Lists.newArrayList();


        SysMenuPojo sysMenuPojo = sysMenuDao.getParentPojo(id);
        menuName.add(sysMenuPojo.getName());


        while (!sysMenuDao.getParentPojo(childId).getParentId().equals(new Long(0))) {
            childId = sysMenuDao.getParentPojo(childId).getParentId();
            menuName.add(sysMenuDao.getParentPojo(childId).getName());
        }
        for (int i = 0; menuName.size() - i > 0; i++) {
            fullPath.append("/" + menuName.get(menuName.size() - i));
        }
        return fullPath.toString();

    }

    /**
     * Ajax 菜单（json格式）
     *
     * @param
     */
    public JSONArray getMenuAjax(Long roleId) {

        JSONArray jsonData = new JSONArray();
        Collection<Condition> conditions = Lists.newArrayList();
        conditions.add(SYS_MENU.PARENT_ID.eq(1L));
        conditions.add(SYS_MENU.DEL_FLAG.eq(false));

        List<SysMenuPojo> list = sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, conditions);
        if (CollectionsTools.isEmpty(list)) {
            return jsonData;
        }
        for (int i = 0; i < list.size(); i++) {
            SysMenuPojo sysMenuPojo = list.get(i);
            JSONObject node = new JSONObject();
            node.put("id", sysMenuPojo.getId());
            node.put("name", sysMenuPojo.getName());
            node.put("permission", sysMenuPojo.getPermission());
            Collection<Condition> condition = Lists.newArrayList();
            condition.add(SYS_MENU.PARENT_ID.eq(sysMenuPojo.getId()));
            condition.add(SYS_MENU.DEL_FLAG.eq(false));
            List<SysMenuPojo> sublist = sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, condition);
            JSONArray submenu = new JSONArray();
            if (CollectionsTools.isNotEmpty(sublist)) {
                for (int j = 0; j < sublist.size(); j++) {
                    SysMenuPojo subSysMenuPojo = sublist.get(j);
                    JSONObject subnode = new JSONObject();
                    subnode.put("id", sysMenuPojo.getId() + "-" + subSysMenuPojo.getId());
                    subnode.put("name", subSysMenuPojo.getName());
                    subnode.put("permission", subSysMenuPojo.getPermission());
                    submenu.put(subnode);
                }
            }

            node.put("submenu", submenu);
            jsonData.put(node);
        }

        return jsonData;
    }

    public List<SysMenuPojo> getMenuListAjax(Long roleId) {

        Collection<Condition> conditions = Lists.newArrayList();
        conditions.add(SYS_MENU.PARENT_ID.eq(1L));
        conditions.add(SYS_MENU.DEL_FLAG.eq(false));

        List<SysMenuPojo> list = sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, conditions);
        if (CollectionsTools.isEmpty(list)) {
            return list;
        }
        list.forEach(pojo -> {
            pojo.setCreateAt(null);
            pojo.setUpdateAt(null);
            pojo.setDelFlag(null);
            pojo.setRemarks(null);
            Collection<Condition> condition = Lists.newArrayList();
            condition.add(SYS_MENU.PARENT_ID.eq(pojo.getId()));
            condition.add(SYS_MENU.DEL_FLAG.eq(false));
            List<SysMenuPojo> pagelist = sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, condition);
            pagelist.forEach(pagePojo -> {
                pagePojo.setCreateAt(null);
                pagePojo.setUpdateAt(null);
                pagePojo.setDelFlag(null);
                pagePojo.setRemarks(null);
                Collection<Condition> actionCondition = Lists.newArrayList();
                actionCondition.add(SYS_MENU.PARENT_ID.eq(pagePojo.getId()));
                actionCondition.add(SYS_MENU.DEL_FLAG.eq(false));
                List<SysMenuPojo> actionlist = sysRoleMenuRepository.getSysRoleMenusByRoleId(roleId, actionCondition);
                actionlist.forEach(actionPojo -> {
                    actionPojo.setCreateAt(null);
                    actionPojo.setUpdateAt(null);
                    actionPojo.setDelFlag(null);
                    actionPojo.setRemarks(null);
                });
                pagePojo.setList(actionlist);
            });
            pojo.setList(pagelist);
        });


        return list;
    }
}