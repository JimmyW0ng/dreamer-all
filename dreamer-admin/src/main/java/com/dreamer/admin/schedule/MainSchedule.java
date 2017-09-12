package com.dreamer.admin.schedule;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.pojo.po.SysDictPojo;
import com.dreamer.admin.pojo.wechat.WechatAccessTokenPojo;
import com.dreamer.admin.service.SysDictService;
import com.dreamer.common.tool.DateTools;
import com.dreamer.common.tool.StringTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 定时任务
 * Created by JW on 17/9/10.
 */
@Slf4j
@Component
public class MainSchedule {

    @Value("${wechat.appid}")
    private String appId;

    @Value("${wechat.secret}")
    private String secret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SysDictService sysDictService;

//    @Autowired
//    private WcSessionTokenRepository wcSessionTokenRepository;

    /**
     * 定时删除过期的微信token
     */
//    @Scheduled(fixedRate = 60000)
//    public void delTimeoutWcToken() {
//        log.info("定时删除过期的微信token...start");
//        Timestamp outTime = DateTools.addMinuteTimestamp(DateTools.getCurrentDateTime(), Constant.WECHAT_SESSION_TIME_OUT_M);
//        int num = wcSessionTokenRepository.deleteTimeoutToken(outTime);
//        log.info("定时删除过期的微信token...end, num={}", num);
//    }

    /**
     * 定时获取微信ACCESS_TOKEN
     */
    @Scheduled(fixedRate = 10 * 60 * 1000)
    public void getWechatAccessToken() {
        log.info("定时获取微信ACCESS_TOKEN...start");
        SysDictPojo sysDictPojo = sysDictService.findByGroupNameAndKey(Constant.DICT_GROUP_WECHAT, Constant.DICT_KEY_WECHAT_ACCESS_TOKEN);
        if (DateTools.addMinute(DateTools.getCurrentDate(), Constant.WECHAT_SESSION_TIME_OUT_M).before(sysDictPojo.getUpdateAt())) {
            return;
        }
        String url = String.format(Constant.WECHAT_URL_ACCESS_TOKEN, appId, secret);
        ResponseEntity<WechatAccessTokenPojo> entity = restTemplate.getForEntity(url, WechatAccessTokenPojo.class);
        log.info("定时获取微信ACCESS_TOKEN...返回：{}", entity);
        if (HttpStatus.OK.equals(entity.getStatusCode())) {
            WechatAccessTokenPojo accessTokenPojo = entity.getBody();
            if (StringTools.isNotBlank(accessTokenPojo.getAccess_token())) {
                log.info("刷新微信ACCESS_TOKEN...accessToken={}", accessTokenPojo.getAccess_token());
                sysDictService.updateByGroupName(Constant.DICT_GROUP_WECHAT, Constant.DICT_KEY_WECHAT_ACCESS_TOKEN, accessTokenPojo.getAccess_token());
            }
        } else {
            log.error("刷新微信ACCESS_TOKEN失败！");
        }
    }

}
