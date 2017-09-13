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
import javax.servlet.http.HttpServletResponse;

/**
 * Created by JW on 17/9/2.
 */
@RestController
@RequestMapping("security")
@Slf4j
public class SessionController extends BaseController {

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
     * 微信小程序码
     *
     * @param path
     * @return
     */
    @RequestMapping(value = "/wechat/code", method = RequestMethod.GET)
    public ResultDo wechatCode(@RequestParam("path") String path, HttpServletResponse response) throws Exception {
        ResultDo<byte[]> resultDo = wcSessionTokenService.buildWechatCode(path);
        if (resultDo.isError()) {
            return resultDo;
        }
        try {
            super.writeResponse(response, resultDo.getResult());
        } catch (Exception e) {
            log.error("微信小程序码获取报错！", e);
        }
        return null;
    }

    /**
     * 微信小程序码(不限制数量)
     *
     * @param scene
     * @param page
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/wechat/code/unlimit", method = RequestMethod.GET)
    public ResultDo wechatCodenlimit(@RequestParam("scene") String scene, @RequestParam("page") String page, HttpServletResponse response) throws Exception {
        ResultDo<byte[]> resultDo = wcSessionTokenService.buildWechatCodeUnlimit(scene, page);
        if (resultDo.isError()) {
            return resultDo;
        }
        try {
            super.writeResponse(response, resultDo.getResult());
        } catch (Exception e) {
            log.error("微信小程序码(不限制数量)获取报错！", e);
        }
        return null;
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
