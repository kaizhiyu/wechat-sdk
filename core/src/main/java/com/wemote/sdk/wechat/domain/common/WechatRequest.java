package com.wemote.sdk.wechat.domain.common;

import com.wemote.sdk.wechat.Const;

import java.util.Map;

/**
 * @author: jayon.xu@gmail.com
 */
public class WechatRequest {

    private String url;
    private Map<String, String> params;
    private String content;
    private String encoding;

    public WechatRequest(String url, Map<String, String> params, String content) {
        this(url, params, content, Const.CHARSET);
    }

    public WechatRequest(String url, Map<String, String> params, String content, String encoding) {
        this.url = url;
        this.params = params;
        this.content = content;
        this.encoding = encoding;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getContent() {
        return content;
    }

    public String getEncoding() {
        return encoding;
    }
}
