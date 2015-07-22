/**
 *
 */
package com.wemote.sdk.wechat.api.server;

import com.wemote.sdk.wechat.api.Config;
import com.wemote.sdk.wechat.api.support.TicketManager;

/**
 * @author jayon.xu@gmail.com
 */
public class JsapiTicketMemServer extends AbsServer implements TicketServer {

    private static JsapiTicketMemServer ticketServer;

    private Config config;

    /**
     * 私有构造
     */
    private JsapiTicketMemServer(Config config) {
        this.config = config;
    }

    /**
     * token中控服务器实例
     *
     * @return ticket服务器实例
     */
    public static JsapiTicketMemServer instance(Config config) {
        if (ticketServer == null) {
            ticketServer = new JsapiTicketMemServer(config);
        }
        return ticketServer;
    }

    @Override
    public Server defaultServer() {
        return this;
    }

    @Override
    public String ticket(String accessToken) {
        return TicketManager.instance(config).getTicket(accessToken).getAccessToken();
    }
}
