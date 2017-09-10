package com.dreamer.admin.repository;

import com.dreamer.admin.domain.enums.SysMenuStatus;
import com.dreamer.admin.domain.tables.records.SysMenuRecord;
import com.dreamer.admin.pojo.po.SysMenuPojo;
import com.dreamer.common.tool.CollectionsTools;
import com.dreamer.common.tool.DateTools;
import com.google.common.collect.Lists;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import static com.dreamer.admin.domain.Tables.SYS_MENU;
import static com.dreamer.admin.domain.Tables.SYS_USER_ROLE;
import static com.dreamer.admin.domain.tables.SysRoleMenu.SYS_ROLE_MENU;

/**
 * Created by jw on 2016/12/10.
 */
@Repository
public class SysMenuRepository extends AbstractCRUDRepository<SysMenuRecord, Long, SysMenuPojo> {


    @Autowired
    public SysMenuRepository(DSLContext dslContext) {
        super(dslContext, SYS_MENU, SYS_MENU.ID, SysMenuPojo.class);
    }

    public List<SysMenuPojo> findSysMenuPojoBySyserId(Long userID) {
        List<Long> syRoles = dslContext.select(SYS_USER_ROLE.SYS_ROLE_ID).from(SYS_USER_ROLE)
                                       .where(SYS_USER_ROLE.SYS_USER_ID.eq(userID)).fetchInto(Long.class);
        List<SysMenuPojo> sysMenuPojos = Lists.newArrayList();


        if (CollectionsTools.isNotEmpty(syRoles)) {
            sysMenuPojos = this.dslContext.selectDistinct().from(SYS_MENU)
                                          .innerJoin(SYS_ROLE_MENU)
                                          .on(SYS_MENU.ID.eq(SYS_ROLE_MENU.SYS_MENU_ID))

                                          .where(SYS_ROLE_MENU.SYS_ROLE_ID.in(syRoles)
                                                                          .and(SYS_MENU.STATUS.eq(SysMenuStatus.enable))
                                                                          .and(SYS_MENU.DEL_FLAG.eq(Boolean.FALSE)))
                                          .fetchInto(SysMenuPojo.class);
        }
        return sysMenuPojos;
    }


    public List<SysMenuPojo> findAll() {
        List<SysMenuPojo> menuPojos = dslContext.selectFrom(SYS_MENU)
                                                .where(SYS_MENU.DEL_FLAG.eq(false))
                                                .orderBy(SYS_MENU.SORT)
                                                .fetchInto(SysMenuPojo.class);
        return menuPojos;
    }


    public List<SysMenuPojo> findChild() {
        List<SysMenuPojo> sysMenuPojos = dslContext.selectFrom(SYS_MENU)
                                                   .where(SYS_MENU.STATUS.eq(SysMenuStatus.enable))
                                                   .and(SYS_MENU.DEL_FLAG.eq(false))
                                                   .and(SYS_MENU.PARENT_ID.eq(1L))
                                                   .orderBy(SYS_MENU.SORT)
                                                   .fetchInto(SysMenuPojo.class);
        sysMenuPojos.forEach(sysMenuPojo -> {
            List<SysMenuPojo> list = dslContext.selectFrom(SYS_MENU)
                                               .where(SYS_MENU.STATUS.eq(SysMenuStatus.enable))
                                               .and(SYS_MENU.DEL_FLAG.eq(false))
                                               .and(SYS_MENU.PARENT_ID.eq(sysMenuPojo.getId()))
                                               .orderBy(SYS_MENU.SORT)
                                               .fetchInto(SysMenuPojo.class);
            sysMenuPojo.setList(list);
        });
        return sysMenuPojos;

    }

    public void deleteByIdLogical(Long id) {
        dslContext.update(SYS_MENU)
                  .set(SYS_MENU.DEL_FLAG, true)
                  .set(SYS_MENU.UPDATE_AT, DateTools.getCurrentDateTime())
                  .where(SYS_MENU.ID.eq(id))
                  .execute();
    }

    public SysMenuPojo getParentPojo(Long childId) {
        SysMenuPojo child = dslContext.select().from(SYS_MENU)
                                      .where(SYS_MENU.DEL_FLAG.eq(false))
                                      .and(SYS_MENU.ID.eq(childId)).fetchOneInto(SysMenuPojo.class);
        return dslContext.select().from(SYS_MENU)
                         .where(SYS_MENU.DEL_FLAG.eq(false))
                         .and(SYS_MENU.ID.eq(child.getParentId())).fetchOneInto(SysMenuPojo.class);
    }


    public List<SysMenuPojo> getSysMenuPojoByCondition(Collection<Condition> conditions) {
        return dslContext.select().from(SYS_MENU)
                         .where(conditions)
                         .fetchInto(SysMenuPojo.class);
    }
}
