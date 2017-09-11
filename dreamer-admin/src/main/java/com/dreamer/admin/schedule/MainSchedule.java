package com.dreamer.admin.schedule;

import com.dreamer.admin.repository.WcSessionTokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * Created by JW on 17/9/10.
 */
@Slf4j
@Component
public class MainSchedule {

    @Autowired
    private WcSessionTokenRepository wcSessionTokenRepository;

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

}
