/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.domain.tables.records;


import com.dreamer.admin.domain.enums.OgnCourseCourseStatus;
import com.dreamer.admin.domain.enums.OgnCoursePeriodType;
import com.dreamer.admin.domain.tables.OgnCourse;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record20;
import org.jooq.Row20;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.9.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class OgnCourseRecord extends UpdatableRecordImpl<OgnCourseRecord> implements Record20<Long, Long, Long, String, String, String, String, Integer, OgnCoursePeriodType, OgnCourseCourseStatus, Integer, Integer, Timestamp, Timestamp, Timestamp, String, Timestamp, Timestamp, Boolean, Long> {

    private static final long serialVersionUID = -1586934228;

    /**
     * Create a detached OgnCourseRecord
     */
    public OgnCourseRecord() {
        super(OgnCourse.OGN_COURSE);
    }

    /**
     * Create a detached, initialised OgnCourseRecord
     */
    public OgnCourseRecord(Long id, Long ognId, Long courseCatalogId, String courseName, String courseTitle, String courseShortIntroduce, String courseAddress, Integer periodNum, OgnCoursePeriodType periodType, OgnCourseCourseStatus courseStatus, Integer enterAgeUpper, Integer enterAgeLower, Timestamp onlineTime, Timestamp enterTimeStart, Timestamp enterTimeEnd, String remarks, Timestamp createAt, Timestamp updateAt, Boolean delFlag, Long version) {
        super(OgnCourse.OGN_COURSE);

        set(0, id);
        set(1, ognId);
        set(2, courseCatalogId);
        set(3, courseName);
        set(4, courseTitle);
        set(5, courseShortIntroduce);
        set(6, courseAddress);
        set(7, periodNum);
        set(8, periodType);
        set(9, courseStatus);
        set(10, enterAgeUpper);
        set(11, enterAgeLower);
        set(12, onlineTime);
        set(13, enterTimeStart);
        set(14, enterTimeEnd);
        set(15, remarks);
        set(16, createAt);
        set(17, updateAt);
        set(18, delFlag);
        set(19, version);
    }

    /**
     * Getter for <code>dreamer.ogn_course.id</code>. 主键
     */
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>dreamer.ogn_course.id</code>. 主键
     */
    public OgnCourseRecord setId(Long value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.ogn_id</code>. 机构ID
     */
    public Long getOgnId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>dreamer.ogn_course.ogn_id</code>. 机构ID
     */
    public OgnCourseRecord setOgnId(Long value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_catalog_id</code>. 课程目录ID
     */
    public Long getCourseCatalogId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_catalog_id</code>. 课程目录ID
     */
    public OgnCourseRecord setCourseCatalogId(Long value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_name</code>. 课名
     */
    public String getCourseName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_name</code>. 课名
     */
    public OgnCourseRecord setCourseName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_title</code>. 课标题
     */
    public String getCourseTitle() {
        return (String) get(4);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_title</code>. 课标题
     */
    public OgnCourseRecord setCourseTitle(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_short_introduce</code>. 课简介
     */
    public String getCourseShortIntroduce() {
        return (String) get(5);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_short_introduce</code>. 课简介
     */
    public OgnCourseRecord setCourseShortIntroduce(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_address</code>. 上课地址
     */
    public String getCourseAddress() {
        return (String) get(6);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_address</code>. 上课地址
     */
    public OgnCourseRecord setCourseAddress(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.period_num</code>. 周期内数量
     */
    public Integer getPeriodNum() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>dreamer.ogn_course.period_num</code>. 周期内数量
     */
    public OgnCourseRecord setPeriodNum(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.period_type</code>. 周期类型：日；周；月；年
     */
    public OgnCoursePeriodType getPeriodType() {
        return (OgnCoursePeriodType) get(8);
    }

    /**
     * Setter for <code>dreamer.ogn_course.period_type</code>. 周期类型：日；周；月；年
     */
    public OgnCourseRecord setPeriodType(OgnCoursePeriodType value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.course_status</code>. 课状态：已保存；已审核；已上线；已下线；
     */
    public OgnCourseCourseStatus getCourseStatus() {
        return (OgnCourseCourseStatus) get(9);
    }

    /**
     * Setter for <code>dreamer.ogn_course.course_status</code>. 课状态：已保存；已审核；已上线；已下线；
     */
    public OgnCourseRecord setCourseStatus(OgnCourseCourseStatus value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.enter_age_upper</code>. 报名年龄上限
     */
    public Integer getEnterAgeUpper() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>dreamer.ogn_course.enter_age_upper</code>. 报名年龄上限
     */
    public OgnCourseRecord setEnterAgeUpper(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.enter_age_lower</code>. 报名年龄下限
     */
    public Integer getEnterAgeLower() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>dreamer.ogn_course.enter_age_lower</code>. 报名年龄下限
     */
    public OgnCourseRecord setEnterAgeLower(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.online_time</code>. 上线时间
     */
    public Timestamp getOnlineTime() {
        return (Timestamp) get(12);
    }

    /**
     * Setter for <code>dreamer.ogn_course.online_time</code>. 上线时间
     */
    public OgnCourseRecord setOnlineTime(Timestamp value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.enter_time_start</code>. 报名开始时间
     */
    public Timestamp getEnterTimeStart() {
        return (Timestamp) get(13);
    }

    /**
     * Setter for <code>dreamer.ogn_course.enter_time_start</code>. 报名开始时间
     */
    public OgnCourseRecord setEnterTimeStart(Timestamp value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.enter_time_end</code>. 报名结束时间
     */
    public Timestamp getEnterTimeEnd() {
        return (Timestamp) get(14);
    }

    /**
     * Setter for <code>dreamer.ogn_course.enter_time_end</code>. 报名结束时间
     */
    public OgnCourseRecord setEnterTimeEnd(Timestamp value) {
        set(14, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.remarks</code>. 备注信息
     */
    public String getRemarks() {
        return (String) get(15);
    }

    /**
     * Setter for <code>dreamer.ogn_course.remarks</code>. 备注信息
     */
    public OgnCourseRecord setRemarks(String value) {
        set(15, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.create_at</code>. 创建时间
     */
    public Timestamp getCreateAt() {
        return (Timestamp) get(16);
    }

    /**
     * Setter for <code>dreamer.ogn_course.create_at</code>. 创建时间
     */
    public OgnCourseRecord setCreateAt(Timestamp value) {
        set(16, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.update_at</code>. 更新时间
     */
    public Timestamp getUpdateAt() {
        return (Timestamp) get(17);
    }

    /**
     * Setter for <code>dreamer.ogn_course.update_at</code>. 更新时间
     */
    public OgnCourseRecord setUpdateAt(Timestamp value) {
        set(17, value);
        return this;
    }

    /**
     * Getter for <code>dreamer.ogn_course.del_flag</code>. 删除标志
     */
    public Boolean getDelFlag() {
        return (Boolean) get(18);
    }

    /**
     * Setter for <code>dreamer.ogn_course.del_flag</code>. 删除标志
     */
    public OgnCourseRecord setDelFlag(Boolean value) {
        set(18, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>dreamer.ogn_course.version</code>.
     */
    public Long getVersion() {
        return (Long) get(19);
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>dreamer.ogn_course.version</code>.
     */
    public OgnCourseRecord setVersion(Long value) {
        set(19, value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<Long, Long, Long, String, String, String, String, Integer, OgnCoursePeriodType, OgnCourseCourseStatus, Integer, Integer, Timestamp, Timestamp, Timestamp, String, Timestamp, Timestamp, Boolean, Long> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row20<Long, Long, Long, String, String, String, String, Integer, OgnCoursePeriodType, OgnCourseCourseStatus, Integer, Integer, Timestamp, Timestamp, Timestamp, String, Timestamp, Timestamp, Boolean, Long> valuesRow() {
        return (Row20) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return OgnCourse.OGN_COURSE.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return OgnCourse.OGN_COURSE.OGN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return OgnCourse.OGN_COURSE.COURSE_CATALOG_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return OgnCourse.OGN_COURSE.COURSE_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return OgnCourse.OGN_COURSE.COURSE_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return OgnCourse.OGN_COURSE.COURSE_SHORT_INTRODUCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return OgnCourse.OGN_COURSE.COURSE_ADDRESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return OgnCourse.OGN_COURSE.PERIOD_NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OgnCoursePeriodType> field9() {
        return OgnCourse.OGN_COURSE.PERIOD_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<OgnCourseCourseStatus> field10() {
        return OgnCourse.OGN_COURSE.COURSE_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return OgnCourse.OGN_COURSE.ENTER_AGE_UPPER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return OgnCourse.OGN_COURSE.ENTER_AGE_LOWER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field13() {
        return OgnCourse.OGN_COURSE.ONLINE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field14() {
        return OgnCourse.OGN_COURSE.ENTER_TIME_START;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field15() {
        return OgnCourse.OGN_COURSE.ENTER_TIME_END;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return OgnCourse.OGN_COURSE.REMARKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field17() {
        return OgnCourse.OGN_COURSE.CREATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field18() {
        return OgnCourse.OGN_COURSE.UPDATE_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field19() {
        return OgnCourse.OGN_COURSE.DEL_FLAG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field20() {
        return OgnCourse.OGN_COURSE.VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getOgnId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getCourseCatalogId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCourseName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getCourseTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getCourseShortIntroduce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getCourseAddress();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getPeriodNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCoursePeriodType value9() {
        return getPeriodType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseCourseStatus value10() {
        return getCourseStatus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getEnterAgeUpper();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getEnterAgeLower();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value13() {
        return getOnlineTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value14() {
        return getEnterTimeStart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value15() {
        return getEnterTimeEnd();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getRemarks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value17() {
        return getCreateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value18() {
        return getUpdateAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value19() {
        return getDelFlag();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value20() {
        return getVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value1(Long value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value2(Long value) {
        setOgnId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value3(Long value) {
        setCourseCatalogId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value4(String value) {
        setCourseName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value5(String value) {
        setCourseTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value6(String value) {
        setCourseShortIntroduce(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value7(String value) {
        setCourseAddress(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value8(Integer value) {
        setPeriodNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value9(OgnCoursePeriodType value) {
        setPeriodType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value10(OgnCourseCourseStatus value) {
        setCourseStatus(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value11(Integer value) {
        setEnterAgeUpper(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value12(Integer value) {
        setEnterAgeLower(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value13(Timestamp value) {
        setOnlineTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value14(Timestamp value) {
        setEnterTimeStart(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value15(Timestamp value) {
        setEnterTimeEnd(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value16(String value) {
        setRemarks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value17(Timestamp value) {
        setCreateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value18(Timestamp value) {
        setUpdateAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value19(Boolean value) {
        setDelFlag(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord value20(Long value) {
        setVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OgnCourseRecord values(Long value1, Long value2, Long value3, String value4, String value5, String value6, String value7, Integer value8, OgnCoursePeriodType value9, OgnCourseCourseStatus value10, Integer value11, Integer value12, Timestamp value13, Timestamp value14, Timestamp value15, String value16, Timestamp value17, Timestamp value18, Boolean value19, Long value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }
}
