package com.dreamer.admin.pojo.po;

import com.dreamer.admin.pojo.AbstractBasePojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by J.W on 2017/9/13 0013.
 */
@Data
public class OgnInfoPojo extends AbstractBasePojo {

    @JsonIgnore
    private Long id;
    private String organName;
    private String organEnglishName;
    private String organAddress;
    private String organShortIntroduce;
    private Timestamp organCreateDate;
    private String organPhone;
    private String organEmail;
    private String orgenUrl;
    private String remark;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Boolean delFlag;
    private Long version;

}
