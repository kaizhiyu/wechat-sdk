package com.wemote.sdk.wechat.shared.kernal;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Strings;
import com.wemote.sdk.wechat.util.Dates;
import com.wemote.sdk.wechat.util.JSONUtils;

import java.io.Serializable;

/**
 * @author: jayon.xu@gmail.com
 */
public class Token implements Serializable {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private int expiresIn;

    private int tokenTime;
    // 提前60秒请求新token
    private int redundancy = 60;

    public Token(String accessToken) {
        this(accessToken, 7200);
    }

    @JSONCreator
    public Token(@JSONField(name = "access_token") String accessToken, @JSONField(name = "expires_in") int expiresIn) {
        this();
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    protected Token() {
        this.tokenTime = Dates.getCurrentSeconds();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public boolean valid() {
        if (Strings.isNullOrEmpty(this.accessToken)) {
            return false;
        }
        if (this.expiresIn <= 0) {
            return false;
        }
        //过期
        if (isExpire()) {
            return false;
        }
        return true;
    }

    /**
     * 是否过期
     *
     * @return
     */
    private boolean isExpire() {
        int currentTime = Dates.getCurrentSeconds();
        int expiresTime = expiresIn - redundancy;
        //判断是否过期
        if ((tokenTime + expiresTime) > currentTime) {
            return false;
        }
        return true;
    }

    @Deprecated
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Deprecated
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @Override
    public String toString() {
        return JSONUtils.toJSONString(this);
    }
}
