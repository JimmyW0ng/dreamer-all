package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.SysLogRecord;
import com.dreamer.admin.pojo.po.SysLogPojo;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.dreamer.admin.domain.Tables.SYS_LOG;

/**
 * Created by jw on 2017/1/16.
 */
@Repository
public class SysLogRepository extends AbstractCRUDRepository<SysLogRecord, Long, SysLogPojo> {

    public SysLogRepository(DSLContext dslContext) {
        super(dslContext, SYS_LOG, SYS_LOG.ID, SysLogPojo.class);
    }
}
