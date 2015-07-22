/**
 *
 */
package com.wemote.sdk.wechat.api.server;

/**
 * Ticket服务器
 */
public interface TicketServer extends Server {
    String ticket(String accessToken);
}
