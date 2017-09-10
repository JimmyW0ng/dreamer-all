package com.dreamer.constant;

/**
 * 常量
 * Created by J.W on 2017/8/11 0011.
 */
public class Constant {

    public static String CURRENT_USER = "currentUser";

    public static Long ADMIN_MENU_HEAD_ID = 1L;

    public static int WECHAT_SESSION_TIME_OUT_M = -60;

    public static String WECHAT_URL_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
}
