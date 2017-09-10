package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.SysUserRecord;
import com.dreamer.admin.pojo.po.SysUserPojo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.dreamer.admin.domain.Tables.SYS_USER;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class SysUserRepository extends AbstractCRUDRepository<SysUserRecord, Long, SysUserPojo> {

    @Autowired
    public SysUserRepository(DSLContext dslContext) {
        super(dslContext, SYS_USER, SYS_USER.ID, SysUserPojo.class);
    }

    public SysUserPojo findByLoginName(String loginName) {
        return fetchOne(SYS_USER.LOGIN_NAME, loginName);
    }

    public int deleteByIdLogical(Long id) {
        return dslContext.update(SYS_USER)
                         .set(SYS_USER.DEL_FLAG, true)
                         .where(SYS_USER.ID.eq(id))
                         .execute();

    }

}
