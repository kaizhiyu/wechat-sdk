package com.wemote.sdk.wechat.api.support;

import com.wemote.sdk.wechat.api.Config;
import com.wemote.sdk.wechat.domain.jsapi.Ticket;
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
public class TicketManager {

    private static final Logger LOG = LoggerFactory.getLogger(TicketManager.class);

    private static TicketManager tokenManager;

    private Ticket ticket;
    private Config config;

    private TicketManager(Config config) {
        this.config = config;
    }

    public static TicketManager instance(Config config) {
        if (tokenManager == null) {
            tokenManager = new TicketManager(config);
        }

        return tokenManager;
    }


    private void refresh(String accessToken) {
        for (int i = 0; i < config.getRetryTimes(); i++) {
            if (this.apply(accessToken)) {
                break;
            }
        }
    }

    /**
     * 获取 token
     *
     * @return
     */
    public Ticket getTicket(String accessToken) {
        if (!ticket.valid()) {
            this.refresh(accessToken);
        }
        LOG.debug("Get js api ticket:{}", ticket);

        return ticket;
    }

    private boolean apply(String accessToken) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(config.getTimeout())
                .setConnectTimeout(config.getConnectTimeout())
                .build();
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setConfig(requestConfig)
                .setUri(Config.BASE_URI + "/cgi-bin/ticket/getticket")
                .addParameter("access_token", accessToken)
                .addParameter("type", "jsapi")
                .build();


        Ticket ticket = LocalHttpClient.executeJSONResult(httpUriRequest, Ticket.class);
        if (ticket != null) {
            this.ticket = ticket;
        }

        return ticket != null;
    }

}
