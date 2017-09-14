package com.dreamer.admin.pojo.po;

import com.dreamer.admin.domain.enums.BscFileBizType;
import com.dreamer.admin.domain.enums.BscFileFileStatus;
import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by J.W on 2017/9/13 0013.
 */
@Data
public class BscFilePojo extends AbstractBasePojo {

    private Long id;
    private String fileName;
    private String fileUrl;
    private BscFileBizType bizType;
    private Long sourceId;
    private Integer order;
    private BscFileFileStatus fileStatus;
    private Timestamp createAt;
    private Timestamp updateAt;
    private String remarks;
    private Boolean delFlag;
    private Long version;

}
