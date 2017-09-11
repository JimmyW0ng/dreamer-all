package com.dreamer.admin.interceptor;

import com.dreamer.common.tool.StringTools;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("微信拦截器预校验开始...");
        String defalut = "4179750395fa71d93081b42e6a3795d7ee0bd8bfc29b8d2f50dd60dd0fcb2a6953ff26a27e65f047e233240ff734bbcb89382d27b1f66c56e84157f27008913d5200ec8a64478e122a44d67d97dfdce6";
        boolean passFlag = true;
        String auth = httpServletRequest.getHeader("Authorization");
        if (StringTools.isBlank(auth)) {
            passFlag = false;
        }
        log.info("微信拦截器预校验结果：{}", passFlag);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
