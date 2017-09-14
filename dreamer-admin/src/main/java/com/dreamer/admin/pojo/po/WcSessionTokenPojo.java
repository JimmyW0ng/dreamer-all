package com.dreamer.admin.pojo.po;

import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 微信会话token
 */
@Data
public class WcSessionTokenPojo extends AbstractBasePojo {

    private Long id;
    private String sessionToken;
    private String openId;
    private String sessionKey;
    private String remarks;
    private Timestamp createAt;
    private Timestamp updateAt;
    private Boolean delFlag;
    private Long version;

}
