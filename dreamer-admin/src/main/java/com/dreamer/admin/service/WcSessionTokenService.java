package com.dreamer.admin.service;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.constant.MessageCodeConstant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.po.SysDictPojo;
import com.dreamer.admin.pojo.wechat.WechatSessionPojo;
import com.dreamer.admin.repository.WcSessionTokenRepository;
import com.dreamer.common.tool.CryptTools;
import com.dreamer.common.tool.DateTools;
import com.dreamer.common.tool.JsonTools;
import com.dreamer.common.tool.StringTools;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Map;

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

    @Value("${token.salt}")
    private String tokenSalt;

    @Autowired
    private WcSessionTokenRepository wcSessionTokenRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SysDictService sysDictService;

    public ResultDo<String> getSessionToken(String code) throws GeneralSecurityException {
        String url = String.format(Constant.WECHAT_URL_SESSION, appId, secret, code);
        ResponseEntity<WechatSessionPojo> entity = restTemplate.getForEntity(url, WechatSessionPojo.class);
        log.info("微信获取session返回：{}", entity);
        if (!HttpStatus.OK.equals(entity.getStatusCode())) {
            return ResultDo.build(MessageCodeConstant.ERROR_WECHAT_HTTP_REQUEST);
        }
        WechatSessionPojo sessionPojo = entity.getBody();
        if (!entity.getBody().isSuccess()) {
            return ResultDo.build(sessionPojo.getErrcode()).setErrorDescription(sessionPojo.getErrmsg());
        }
        String sessionKey = sessionPojo.getSession_key();
        String openId = sessionPojo.getOpenid();
        // 目前不存储到数据库
        String randomStr = StringTools.getRandomStr(8);
        Long timeout = DateTools.addHour(DateTools.getCurrentDate(), 1).getTime();
        String key = openId + Constant.KEY_SPLIT + sessionKey + Constant.KEY_SPLIT + timeout + Constant.KEY_SPLIT + randomStr;
        String encode = CryptTools.aesEncrypt(key, tokenSalt);
//        String sessionToken = UUID.randomUUID().toString();
//        WcSessionTokenPojo wcSessionTokenPojo = new WcSessionTokenPojo();
//        wcSessionTokenPojo.setOpenId(openId);
//        wcSessionTokenPojo.setSessionKey(sessionKey);
//        wcSessionTokenPojo.setSessionToken(sessionToken);
//        wcSessionTokenRepository.create(wcSessionTokenPojo);
//        return ResultDo.build().setResult(sessionToken);
        // session先不存储到数据库
        return ResultDo.build().setResult(encode);
    }

    /**
     * 生成小程序码
     *
     * @param scene
     * @param page
     * @return
     */
    public ResultDo<byte[]> buildWechatCodeUnlimit(String scene, String page) {
        // 获取token
        ResultDo accessTokenResultDo = this.getAccessToken();
        if (accessTokenResultDo.isError()) {
            return accessTokenResultDo;
        }
        String url = String.format(Constant.WECHAT_URL_WECHAT_CODE_UNLIMIT, accessTokenResultDo.getResult());
        Map<String, String> data = Maps.newHashMap();
        data.put("scene", scene);
        data.put("page", page);
        ResponseEntity<byte[]> entity = restTemplate.postForEntity(url, JsonTools.encode(data), byte[].class);
        if (!HttpStatus.OK.equals(entity.getStatusCode())) {
            return ResultDo.build(MessageCodeConstant.ERROR_WECHAT_HTTP_REQUEST);
        }
        log.info("生成小程序码返回：{}", Base64.getEncoder().encode(entity.getBody()));
        return ResultDo.build().setResult(entity.getBody());
    }

    /**
     * 生成小程序码(不限制数量)
     *
     * @param path
     * @return
     */
    public ResultDo<byte[]> buildWechatCode(String path) {
        // 获取token
        ResultDo accessTokenResultDo = this.getAccessToken();
        if (accessTokenResultDo.isError()) {
            return accessTokenResultDo;
        }
        String url = String.format(Constant.WECHAT_URL_WECHAT_CODE, accessTokenResultDo.getResult());
        Map<String, String> data = Maps.newHashMap();
        data.put("path", path);
        ResponseEntity<byte[]> entity = restTemplate.postForEntity(url, JsonTools.encode(data), byte[].class);
        if (!HttpStatus.OK.equals(entity.getStatusCode())) {
            return ResultDo.build(MessageCodeConstant.ERROR_WECHAT_HTTP_REQUEST);
        }
        log.info("生成小程序码返回：{}", Base64.getEncoder().encode(entity.getBody()));
        return ResultDo.build().setResult(entity.getBody());
    }

    private ResultDo getAccessToken() {
        SysDictPojo dictPojo = sysDictService.findByGroupNameAndKey(Constant.DICT_GROUP_WECHAT, Constant.DICT_KEY_WECHAT_ACCESS_TOKEN);
        if (dictPojo == null
                || dictPojo.getValue() == null
                || dictPojo.getUpdateAt() == null
                || DateTools.addMinute(DateTools.getCurrentDate(), Constant.WECHAT_SESSION_TIME_OUT_M).after(dictPojo.getUpdateAt())) {
            return ResultDo.build(MessageCodeConstant.ERROR_DATA_MISS);
        }
        return ResultDo.build().setResult(dictPojo.getValue());
    }
}
