package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.WcSessionTokenRecord;
import com.dreamer.admin.pojo.po.WcSessionTokenPojo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

import static com.dreamer.admin.domain.Tables.WC_SESSION_TOKEN;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class WcSessionTokenRepository extends AbstractCRUDRepository<WcSessionTokenRecord, Long, WcSessionTokenPojo> {

    @Autowired
    public WcSessionTokenRepository(DSLContext dslContext) {
        super(dslContext, WC_SESSION_TOKEN, WC_SESSION_TOKEN.ID, WcSessionTokenPojo.class);
    }

    /**
     * 定时删除过期的微信token
     *
     * @return
     */
    public int deleteTimeoutToken(Timestamp outTime) {
        return dslContext.deleteFrom(WC_SESSION_TOKEN)
                .where(WC_SESSION_TOKEN.CREATE_TIME.le(outTime))
                .execute();
    }
}

