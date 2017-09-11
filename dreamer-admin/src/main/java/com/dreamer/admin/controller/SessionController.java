package com.dreamer.admin.controller;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.service.WcSessionTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping(value = "/wechat/auth/info", method = RequestMethod.POST)
    public ResultDo wechatMemberInfo(HttpServletRequest request) {
        log.info("{}", request.getAttribute(Constant.WECHAT_REQ_CURRENT_SESSION));
        return ResultDo.build().setResult("token验证成功");
    }

}
