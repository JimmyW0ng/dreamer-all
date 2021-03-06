/*
 * This file is generated by jOOQ.
*/
package com.dreamer.admin.pojo.po;


import com.dreamer.admin.domain.enums.OgnCourseCourseStatus;
import com.dreamer.admin.domain.enums.OgnCoursePeriodType;
import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;

import java.sql.Timestamp;


/**
 * Created by J.W on 2017/9/13 0013.
 */
@Data
public class OgnCoursePojo extends AbstractBasePojo {

    private Long id;
    private Long ognId;
    private Long courseCatalogId;
    private String courseName;
    private String courseTitle;
    private String courseShortIntroduce;
    private String courseAddress;
    private Integer periodNum;
    private OgnCoursePeriodType periodType;
    private OgnCourseCourseStatus courseStatus;
    private Integer enterAgeUpper;
    private Integer enterAgeLower;
    private Timestamp onlineTime;
    private Timestamp enterTimeStart;
    private Timestamp enterTimeEnd;
    private String headImage;
    private String remark;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Boolean delFlag;
    private Long version;

}
