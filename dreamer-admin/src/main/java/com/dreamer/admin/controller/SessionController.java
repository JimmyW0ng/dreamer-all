package com.dreamer.admin.controller;

import com.dreamer.admin.constant.MessageCodeConstant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.service.WcSessionTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JW on 17/9/2.
 */
@RestController
@RequestMapping("security")
@Slf4j
public class SessionController {

    @Autowired
    private WcSessionTokenService wcSessionTokenService;

    /**
     * 创建微信会话
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/wechat/session", method = RequestMethod.GET)
    public ResultDo<String> wechatSession(@RequestParam("code") String code) throws Exception {
        return wcSessionTokenService.getSessionToken(code);
    }

    /**
     * 获取微信用户信息
     *
     * @return
     */
    @RequestMapping(value = "/wechat/member/info", method = RequestMethod.POST)
    public ResultDo wechatMemberInfo() {
        return ResultDo.build();
    }

    /**
     * 异常会话返回
     *
     * @return
     */
    @RequestMapping(value = "/session/error", method = RequestMethod.GET)
    public ResultDo sessionError() {
        return ResultDo.build(MessageCodeConstant.ERROR_SESSION_TOKEN);
    }

}
