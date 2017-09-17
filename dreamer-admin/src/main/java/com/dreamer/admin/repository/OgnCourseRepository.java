package com.dreamer.admin.repository;

import com.dreamer.admin.domain.tables.records.OgnCourseRecord;
import com.dreamer.admin.pojo.po.OgnCoursePojo;
import org.jooq.DSLContext;
import org.jooq.SelectField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dreamer.admin.domain.Tables.CST_COURSE_CATALOG;
import static com.dreamer.admin.domain.Tables.OGN_COURSE;

/**
 * Created by jw on 2016/12/12.
 */
@Repository
public class OgnCourseRepository extends AbstractCRUDRepository<OgnCourseRecord, Long, OgnCoursePojo> {

    @Autowired
    public OgnCourseRepository(DSLContext dslContext) {
        super(dslContext, OGN_COURSE, OGN_COURSE.ID, OgnCoursePojo.class);
    }

    public List<OgnCoursePojo> getByOgnId(Long ognId) {
        SelectField[] selectFields = OGN_COURSE.fields();
        selectFields[OGN_COURSE.fields().length] = CST_COURSE_CATALOG.LABEL;
        return dslContext.select(selectFields).from(OGN_COURSE)
                .leftJoin(CST_COURSE_CATALOG)
                .on(OGN_COURSE.COURSE_CATALOG_ID.eq(CST_COURSE_CATALOG.ID))
                .and(CST_COURSE_CATALOG.DEL_FLAG.eq(false))
                .where(OGN_COURSE.OGN_ID.eq(ognId))
                .and(OGN_COURSE.DEL_FLAG.eq(false))
                .fetchInto(OgnCoursePojo.class);
    }

}

