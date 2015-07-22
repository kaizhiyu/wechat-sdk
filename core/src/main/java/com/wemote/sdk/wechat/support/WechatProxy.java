package com.wemote.sdk.wechat.support;

import com.google.common.base.Preconditions;
import com.wemote.sdk.wechat.domain.common.WechatRequest;
import com.wemote.sdk.wechat.domain.common.WechatResponse;
import com.wemote.sdk.wechat.util.http.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author: jayon.xu@gmail.com
 */
public class WechatProxy {

    private static final Logger LOG = LoggerFactory.getLogger(WechatProxy.class);

    public static WechatResponse doGet(WechatRequest request) {
        Preconditions.checkNotNull(request, "Request obj must be not null.");
        try {
            String content = HttpUtils.doGet(request.getUrl(), request.getEncoding(), true);
            if (content != null) {
                return new WechatResponse(content);
            }
        } catch (IOException e) {
            LOG.warn("Do get request error:{}", e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static WechatResponse doPost(WechatRequest request) {
        Preconditions.checkNotNull(request, "Request obj must be not null.");
        try {
            String content = HttpUtils.doPost(request.getUrl(), request.getParams(), request.getEncoding());
            if (content != null) {
                return new WechatResponse(content);
            }
        } catch (IOException e) {
            LOG.warn("Do get request error:{}", e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
