package com.dreamer.admin.interceptor;

import com.dreamer.admin.constant.Constant;
import com.dreamer.admin.constant.MessageCodeConstant;
import com.dreamer.admin.pojo.ResultDo;
import com.dreamer.admin.pojo.bo.WechatSessionBo;
import com.dreamer.common.tool.CryptTools;
import com.dreamer.common.tool.DateTools;
import com.dreamer.common.tool.StringTools;
import com.dreamer.common.tool.WebTools;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 微信拦截器
 * Created by J.W on 2017/9/11 0011.
 */
@Slf4j
@Data
public class WechatTokenInterceptor implements HandlerInterceptor {

    private String salt;

    public WechatTokenInterceptor(String salt) {
        this.salt = salt;
    }

    /**
     * token验证，例：4179750395fa71d93081b42e6a3795d7ee0bd8bfc29b8d2f50dd60dd0fcb2a6953ff26a27e65f047e233240ff734bbcb89382d27b1f66c56e84157f27008913d5200ec8a64478e122a44d67d97dfdce6
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("微信拦截器预校验开始...");
        String auth = httpServletRequest.getHeader("Authorization");
        try {
            if (StringTools.isBlank(auth)) {
                WebTools.writeJsonResponse(httpServletResponse, ResultDo.build(MessageCodeConstant.ERROR_SESSION_TOKEN));
                return false;
            }
            String[] deCode = CryptTools.aesDecrypt(auth, this.salt).split(Constant.KEY_SPLIT);
            String openId = deCode[0];
            String sessionKey = deCode[1];
            Date timeOut = new Date(Long.parseLong(deCode[2]));
            String random = deCode[3];
            if (StringTools.isBlank(openId)
                    || StringTools.isBlank(sessionKey)
                    || StringTools.isBlank(random)
                    || timeOut.before(DateTools.getCurrentDate())) {
                WebTools.writeJsonResponse(httpServletResponse, ResultDo.build(MessageCodeConstant.ERROR_SESSION_TOKEN));
                return false;
            }
            WechatSessionBo sessionBo = new WechatSessionBo(openId, sessionKey);
            httpServletRequest.setAttribute(Constant.WECHAT_REQ_CURRENT_SESSION, sessionBo);
            return true;
        } catch (Exception e) {
            log.error("解析微信token报错！auth={}", auth, e);
            WebTools.writeJsonResponse(httpServletResponse, ResultDo.build(MessageCodeConstant.ERROR_SESSION_TOKEN));
            return false;
        } finally {
            log.info("微信拦截器预校验结束");
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
