package com.wemote.sdk.wechat.api;

/**
 * @author: jayon.xu@gmail.com
 */
public class Config {

    public static final String BASE_URI = "https://api.weixin.qq.com";
    public static final String MEDIA_URI = "http://file.api.weixin.qq.com";
    public static final String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";
    public static final String MCH_URI = "https://api.mch.weixin.qq.com";
    public static final String OPEN_URI = "https://open.weixin.qq.com";

    //默认请求超时时间：10秒
    private int timeout = (10 * 1000);
    //默认连接超时时间：5秒
    private int connectTimeout = (5 * 1000);
    //默认重试次数：3次
    private int retryTimes = 3;

    private String appId;
    private String appSecret;
    private String token;

    public Config(String appId, String appSecret, String token) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.token = token;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getToken() {
        return token;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getRetryTimes() {
        return retryTimes;
    }
}
