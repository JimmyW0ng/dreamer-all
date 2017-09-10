package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.SysUserRoleRecord;
import com.dreamer.admin.pojo.po.SysUserRolePojo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dreamer.admin.domain.Tables.SYS_USER_ROLE;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class SysUserRoleRepository extends AbstractCRUDRepository<SysUserRoleRecord, Long, SysUserRolePojo> {

    @Autowired
    public SysUserRoleRepository(DSLContext dslContext) {
        super(dslContext, SYS_USER_ROLE, SYS_USER_ROLE.ID, SysUserRolePojo.class);
    }

    public List<SysUserRolePojo> findByUserId(Long userId) {
        return fetchList(SYS_USER_ROLE.SYS_USER_ID, userId);
    }

    public void deleteByUserId(Long userId) {
        dslContext.delete(SYS_USER_ROLE).where(SYS_USER_ROLE.SYS_USER_ID.eq(userId)).execute();
    }

    public void deleteByUserIdAndRoleId(Long userId, Long roleId) {
        dslContext.delete(SYS_USER_ROLE).where(SYS_USER_ROLE.SYS_USER_ID.eq(userId).and(SYS_USER_ROLE.SYS_ROLE_ID.eq(roleId))).execute();
    }

}

