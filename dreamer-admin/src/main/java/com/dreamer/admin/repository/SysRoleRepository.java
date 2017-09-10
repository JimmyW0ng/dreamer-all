package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.SysRoleRecord;
import com.dreamer.admin.pojo.po.SysRolePojo;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dreamer.admin.domain.Tables.SYS_ROLE;

/**
 * Created by FeiCongcong on 2017/1/12 0012.
 */
@Repository
public class SysRoleRepository extends AbstractCRUDRepository<SysRoleRecord, Long, SysRolePojo> {
    @Autowired
    public SysRoleRepository(DSLContext dslContext) {
        super(dslContext, SYS_ROLE, SYS_ROLE.ID, SysRolePojo.class);
    }

    public List<SysRolePojo> findAll() {
        Result<SysRoleRecord> fetch = dslContext.selectFrom(SYS_ROLE)
                                                .where(SYS_ROLE.DEL_FLAG.eq(false)).fetch();
        List<SysRolePojo> sysRolePojos = dslContext.selectFrom(SYS_ROLE)
                                                   .where(SYS_ROLE.DEL_FLAG.eq(false))
                                                   .fetchInto(SysRolePojo.class);
        return sysRolePojos;
    }

    public void deleteById(Long id) {
        delete(id);
    }

    public void deleteByIdLogical(Long id) {
        dslContext.update(SYS_ROLE)
                  .set(SYS_ROLE.DEL_FLAG, true)
                  .where(SYS_ROLE.ID.eq(id))
                  .execute();

    }

}
