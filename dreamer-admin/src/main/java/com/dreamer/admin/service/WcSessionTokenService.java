package com.dreamer.admin.service;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.po.WcSessionTokenPojo;
import com.dreamer.admin.pojo.wechat.WechatSessionPojo;
import com.dreamer.admin.repository.WcSessionTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * 微信会话token接口
 * Created by JW on 17/9/10.
 */
@Slf4j
@Service
public class WcSessionTokenService {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Autowired
    private WcSessionTokenRepository wcSessionTokenRepository;

    @Autowired
    private RestTemplate restTemplate;

    public ResultDo<String> getSessionToken(String code) {
        String url = String.format(Constant.WECHAT_URL_SESSION, appId, secret, code);
        ResponseEntity<WechatSessionPojo> entity = restTemplate.getForEntity(url, WechatSessionPojo.class);
        log.info("微信获取session返回：{}", entity);
        WechatSessionPojo sessionPojo = entity.getBody();
        if (!entity.getBody().isSuccess()) {
            return ResultDo.build(sessionPojo.getErrcode()).setErrorDescription(sessionPojo.getErrmsg());
        }
        String sessionKey = sessionPojo.getSession_key();
        String openId = sessionPojo.getOpenid();
        String sessionToken = UUID.randomUUID().toString();
        WcSessionTokenPojo wcSessionTokenPojo = new WcSessionTokenPojo();
        wcSessionTokenPojo.setOpenId(openId);
        wcSessionTokenPojo.setSessionKey(sessionKey);
        wcSessionTokenPojo.setSessionToken(sessionToken);
        wcSessionTokenRepository.create(wcSessionTokenPojo);
        return ResultDo.build().setResult(sessionToken);
    }

}
