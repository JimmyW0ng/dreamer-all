package com.dreamer.admin.pojo.bo;

import com.dreamer.admin.pojo.AbstractBasePojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by JW on 17/9/11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WechatSessionBo extends AbstractBasePojo {

    private String openId;
    private String sessionKey;

}
