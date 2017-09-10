package com.dreamer.pojo.wechat;

import com.dreamer.common.tool.StringTools;
import com.dreamer.pojo.AbstractBasePojo;
import lombok.Data;

/**
 * Created by JW on 17/9/9.
 */
@Data
public class WechatBasePojo extends AbstractBasePojo {

    private String errcode;
    private String errmsg;

    public Boolean isSuccess() {
        if (StringTools.isBlank(errcode)) {
            return true;
        }
        return false;
    }

}
