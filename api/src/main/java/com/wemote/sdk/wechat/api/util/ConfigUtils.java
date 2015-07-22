package com.wemote.sdk.wechat.api.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: jayon.xu@gmail.com
 */
public class ConfigUtils {

    private static Properties props = new Properties();

    public static final String KEY_APP_ID = "appId";
    public static final String KEY_APP_SECRET = "appSecret";
    public static final String KEY_APP_TOKEN = "token";

    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("wechat.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConfigUtils() {
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static String getAppId() {
        return props.getProperty(KEY_APP_ID);
    }

    public static String getAppSecret() {
        return props.getProperty(KEY_APP_SECRET);
    }

    public static String getToken() {
        return props.getProperty(KEY_APP_TOKEN);
    }
}
