package com.dreamer.business.repository;

import com.dreamer.domain.enums.SysMenuStatus;
import com.dreamer.domain.enums.SysMenuType;
import com.dreamer.domain.tables.SysRoleMenu;
import com.dreamer.domain.tables.records.SysRoleMenuRecord;
import com.dreamer.pojo.po.SysMenuPojo;
import com.dreamer.pojo.po.SysRoleMenuPojo;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import static com.dreamer.domain.Tables.SYS_MENU;
import static com.dreamer.domain.Tables.SYS_ROLE_MENU;

/**
 * Created by jw on 2017/1/16 0016.
 */
@Repository
public class SysRoleMenuRepository extends AbstractCRUDRepository<SysRoleMenuRecord, Long, SysRoleMenuPojo> {
    @Autowired
    public SysRoleMenuRepository(DSLContext dslContext) {
        super(dslContext, SYS_ROLE_MENU, SYS_ROLE_MENU.ID, SysRoleMenuPojo.class);
    }

    public List<SysRoleMenuPojo> findByRoleId(Long roleId) {
        return fetchList(SYS_ROLE_MENU.SYS_ROLE_ID, roleId);
    }

    public void deleteByRoleId(Long id) {
        dslContext.delete(SYS_ROLE_MENU).where(SYS_ROLE_MENU.SYS_ROLE_ID.eq(id)).execute();
    }

    public void deleteByRoleIdAndMenuId(Long roleId, Long menuId) {
        dslContext.delete(SYS_ROLE_MENU).where(SYS_ROLE_MENU.SYS_MENU_ID.eq(menuId).and(SYS_ROLE_MENU.SYS_ROLE_ID.eq(roleId))).execute();
    }

    public void deleteByMenuId(Long menuId) {
        dslContext.delete(SYS_ROLE_MENU).where(SYS_ROLE_MENU.SYS_MENU_ID.eq(menuId)).execute();

    }

    public List<SysMenuPojo> getSysRoleMenusByRoleId(Long roleId, Collection<Condition> conditions) {
//        List<Field<?>> col= Lists.newArrayList();
//        SYS_MENU.fields()
//        col.add(SYS_ROLE_MENU.SYS_MENU_ID.as("id"));
        conditions.add(SYS_ROLE_MENU.SYS_ROLE_ID.eq(roleId));
        return dslContext.select(SYS_MENU.fields())
                         .from(SYS_ROLE_MENU)
                         .leftJoin(SYS_MENU)
                         .on(SYS_ROLE_MENU.SYS_MENU_ID.eq(SYS_MENU.ID))
                         .where(conditions)
                         .fetchInto(SysMenuPojo.class);

    }


    /**
     * 根据父级菜单和角色获取菜单
     *
     * @param rols
     * @return
     */
    public List<SysMenuPojo> getMenusWithRoleAndParentId(List<Long> rols, SysMenuType menuType, Long parentId) {
        // 获取菜单
        return dslContext.selectFrom(SYS_MENU.innerJoin(SysRoleMenu.SYS_ROLE_MENU)
                                             .on(SysRoleMenu.SYS_ROLE_MENU.SYS_MENU_ID.eq(SYS_MENU.ID))
                                             .and(SysRoleMenu.SYS_ROLE_MENU.SYS_ROLE_ID.in(rols)))
                         .where(SYS_MENU.STATUS.eq(SysMenuStatus.enable))
                         .and(SYS_MENU.TYPE.eq(menuType))
                         .and(SYS_MENU.DEL_FLAG.eq(false))
                         .and(SYS_MENU.PARENT_ID.eq(parentId))
                         .orderBy(SYS_MENU.SORT)
                         .fetchInto(SysMenuPojo.class);
    }
}

