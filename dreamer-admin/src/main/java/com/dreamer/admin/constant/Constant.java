package com.dreamer.admin.constant;

/**
 * 常量
 * Created by J.W on 2017/8/11 0011.
 */
public class Constant {

    public static String KEY_SPLIT = ":";

    // api

    // backend
    public static String CURRENT_USER = "currentUser";

    public static Long ADMIN_MENU_HEAD_ID = 1L;

    // dict
    public static String DICT_GROUP_WECHAT = "WECHAT";
    public static String DICT_KEY_WECHAT_ACCESS_TOKEN = "WECHAT_ACCESS_TOKEN";

    // wechat
    public static String WECHAT_REQ_CURRENT_SESSION = "currentWechatSession";

    public static int WECHAT_SESSION_TIME_OUT_M = -60;

    public static String WECHAT_URL_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    public static String WECHAT_URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    public static String WECHAT_URL_WECHAT_CODE = "https://api.weixin.qq.com/wxa/getwxacode?access_token=%s";

    public static String WECHAT_URL_WECHAT_CODE_UNLIMIT = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";
}
