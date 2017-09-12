package com.dreamer.admin.pojo.wechat;

import lombok.Data;

/**
 * Created by JW on 17/9/9.
 */
@Data
public class WechatAccessTokenPojo extends WechatBasePojo {

    private String access_token;
    private Integer expires_in;

}
