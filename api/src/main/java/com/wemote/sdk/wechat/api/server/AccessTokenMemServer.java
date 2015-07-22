package com.wemote.sdk.wechat.api.server;

import com.wemote.sdk.wechat.api.Config;
import com.wemote.sdk.wechat.api.support.TokenManager;
import com.wemote.sdk.wechat.domain.access.AccessToken;

/**
 * 内存中控服务器
 * access_token 中控服务器
 * access_token保存在内存中,过期则自动刷新
 * 此中控服务器采用单例模式，提供单一的访问点，并且持有全局唯一的accessToken对象
 * 采用这种模式而不是AccessToken提供全局唯一访问是
 * 因为AccessToken需要为其他类型的中控服务器提供服务，
 * 比如是定时器刷新存数据库或者文件之类的就不需要提供全局唯一
 *
 * @author jayon.xu@gmail.com
 */
public class AccessTokenMemServer extends AbsServer implements TokenServer {

    private static AccessTokenMemServer tokenServer;

    private Config config;

    private AccessTokenMemServer(Config config) {
        this.config = config;
    }

    public static AccessTokenMemServer instance(final Config config) {
        if (tokenServer == null) {
            tokenServer = new AccessTokenMemServer(config);
        }
        return tokenServer;
    }

    /**
     * 通过中控服务器得到token
     *
     * @return
     */
    private AccessToken accessToken() {
        return TokenManager.instance(config).getToken();
    }

    /**
     * 通过中控服务器得到accessToken
     *
     * @return
     */
    public String token() {
        return accessToken().getAccessToken();
    }

    @Override
    public Server defaultServer() {
        return this;
    }
}
