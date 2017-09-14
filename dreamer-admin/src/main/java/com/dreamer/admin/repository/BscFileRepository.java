package com.dreamer.admin.repository;

import com.dreamer.admin.domain.enums.BscFileBizType;
import com.dreamer.admin.domain.tables.records.BscFileRecord;
import com.dreamer.admin.pojo.po.BscFilePojo;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dreamer.admin.domain.Tables.BSC_FILE;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class BscFileRepository extends AbstractCRUDRepository<BscFileRecord, Long, BscFilePojo> {

    @Autowired
    public BscFileRepository(DSLContext dslContext) {
        super(dslContext, BSC_FILE, BSC_FILE.ID, BscFilePojo.class);
    }

    /**
     * 定时删除过期的微信token
     *
     * @return
     */
    public List<BscFilePojo> getByBizTypeAndSourceId(BscFileBizType bscFileBizType, Long sourceId) {
        return dslContext.selectFrom(BSC_FILE)
                         .where(BSC_FILE.BIZ_TYPE.eq(bscFileBizType))
                         .and(BSC_FILE.SOURCE_ID.eq(sourceId))
                         .and(BSC_FILE.DEL_FLAG.eq(false))
                         .fetchInto(BscFilePojo.class);
    }
}

