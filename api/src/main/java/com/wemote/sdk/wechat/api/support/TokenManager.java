package com.wemote.sdk.wechat.api.support;

import com.wemote.sdk.wechat.Const;
import com.wemote.sdk.wechat.api.Config;
import com.wemote.sdk.wechat.domain.access.AccessToken;
import com.wemote.sdk.wechat.support.http.client.LocalHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TokenManager token 自动刷新
 *
 * @author jayon.xu@gmail.com
 */
public class TokenManager {

    private static final Logger LOG = LoggerFactory.getLogger(TokenManager.class);

    private static TokenManager tokenManager;

    private AccessToken accessToken;
    private Config config;

    private TokenManager(Config config) {
        this.config = config;
        // 初始申请access token
        this.apply();
    }

    public static TokenManager instance(Config config) {
        if (tokenManager == null) {
            tokenManager = new TokenManager(config);
        }

        return tokenManager;
    }


    private void refresh() {
        for (int i = 0; i < config.getRetryTimes(); i++) {
            if (this.apply()) {
                break;
            }
        }
    }

    /**
     * 获取 token
     *
     * @return
     */
    public AccessToken getToken() {
        if (!accessToken.valid()) {
            this.refresh();
        }
        LOG.debug("Get access token:{}", accessToken);

        return accessToken;
    }

    private boolean apply() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(config.getTimeout())
                .setConnectTimeout(config.getConnectTimeout())
                .build();
        HttpUriRequest httpUriRequest = RequestBuilder.post().setConfig(requestConfig)
                .setUri(Config.BASE_URI + "/cgi-bin/token")
                .setHeader("User-Agent", Const.USER_AGENT)
                .addParameter("grant_type", "client_credential")
                .addParameter("appid", config.getAppId())
                .addParameter("secret", config.getAppSecret())
                .build();

        AccessToken accessToken = LocalHttpClient.executeJSONResult(httpUriRequest, AccessToken.class);
        if (accessToken != null) {
            this.accessToken = accessToken;
        }

        return accessToken != null;
    }

}
