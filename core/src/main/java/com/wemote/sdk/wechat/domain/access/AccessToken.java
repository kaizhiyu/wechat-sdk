package com.wemote.sdk.wechat.domain.access;

import com.wemote.sdk.wechat.shared.kernal.Token;

/**
 * @author: jayon.xu@gmail.com
 */
public class AccessToken extends Token {

    protected AccessToken() {
        super();
    }

    public AccessToken(String accessToken, int expiresIn) {
        super(accessToken, expiresIn);
    }
}
