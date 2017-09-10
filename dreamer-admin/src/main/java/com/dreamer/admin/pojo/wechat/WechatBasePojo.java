package com.dreamer.admin.pojo.wechat;

import com.dreamer.admin.pojo.AbstractBasePojo;
import com.dreamer.common.tool.StringTools;
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
