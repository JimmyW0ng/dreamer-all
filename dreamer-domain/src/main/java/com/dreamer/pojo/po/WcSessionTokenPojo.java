package com.dreamer.pojo.po;

import com.dreamer.pojo.AbstractBasePojo;
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
    private Timestamp createTime;

}
