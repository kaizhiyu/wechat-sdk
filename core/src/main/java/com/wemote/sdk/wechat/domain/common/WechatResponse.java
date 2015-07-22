package com.wemote.sdk.wechat.domain.common;

/**
 * @author: jayon.xu@gmail.com
 */
public class WechatResponse {

    private String content;

    public WechatResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
