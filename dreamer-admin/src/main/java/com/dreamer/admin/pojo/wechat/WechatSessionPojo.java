package com.dreamer.admin.pojo.wechat;

import lombok.Data;

/**
 * Created by JW on 17/9/9.
 */
@Data
public class WechatSessionPojo extends WechatBasePojo {

    private String openid;
    private String session_key;
    private String unionid;
    private Integer expires_in;
}
