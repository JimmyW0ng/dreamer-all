package com.dreamer.admin.controller;

import com.dreamer.admin.pojo.ResultDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JW on 17/9/2.
 */
@Controller
@RequestMapping("security")
@Slf4j
public class SessionController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/wechat/login", method = RequestMethod.GET)
    @ResponseBody
    public ResultDo index(Model model) {
        return ResultDo.build();
    }

    private void getSession() {
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        restTemplate.getForObject()
                ? appid = APPID & secret = SECRET & js_code = JSCODE & grant_type = authorization_code
    }
}
