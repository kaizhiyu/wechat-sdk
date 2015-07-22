package com.wemote.sdk.wechat.api.server;

/**
 * @author jayon.xu@gmail.com
 */
public abstract class AbsServer implements Server {

    public Server server() {
        return defaultServer();
    }

    public abstract Server defaultServer();
}
