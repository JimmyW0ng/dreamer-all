package com.dreamer.admin.controller;

import com.dreamer.business.service.WcSessionTokenService;
import com.dreamer.pojo.ResultDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JW on 17/9/2.
 */
@Controller
@RequestMapping("security")
@Slf4j
public class SessionController {

    @Autowired
    private WcSessionTokenService wcSessionTokenService;

    @RequestMapping(value = "/wechat/session", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo<String> wechatLogin(@RequestParam("code") String code) {
        return wcSessionTokenService.getSessionToken(code);
    }

}
