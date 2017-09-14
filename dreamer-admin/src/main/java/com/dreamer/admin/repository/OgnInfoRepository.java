package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.OgnInfoRecord;
import com.dreamer.admin.pojo.po.OgnInfoPojo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.dreamer.admin.domain.Tables.OGN_INFO;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class OgnInfoRepository extends AbstractCRUDRepository<OgnInfoRecord, Long, OgnInfoPojo> {

    @Autowired
    public OgnInfoRepository(DSLContext dslContext) {
        super(dslContext, OGN_INFO, OGN_INFO.ID, OgnInfoPojo.class);
    }

}

