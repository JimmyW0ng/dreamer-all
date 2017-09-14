package com.dreamer.admin.pojo.po;

import com.dreamer.admin.domain.enums.BscFileBizType;
import com.dreamer.admin.domain.enums.BscFileFileStatus;
import com.dreamer.admin.pojo.AbstractBasePojo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by J.W on 2017/9/13 0013.
 */
@Data
public class BscFilePojo extends AbstractBasePojo {

    @JsonIgnore
    private Long id;
    private String fileName;
    private String fileUrl;
    private BscFileBizType bizType;
    private Long sourceId;
    private BscFileFileStatus fileStatus;
    @JsonIgnore
    private Timestamp createAt;
    @JsonIgnore
    private Timestamp updateAt;
    @JsonIgnore
    private String remarks;
    @JsonIgnore
    private Boolean delFlag;

}
