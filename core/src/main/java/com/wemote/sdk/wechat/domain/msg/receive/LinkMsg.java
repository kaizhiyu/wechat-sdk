package com.wemote.sdk.wechat.domain.msg.receive;

import com.wemote.sdk.wechat.util.Dates;

/**
 * @author: jayon.xu@gmail.com
 */
public class LinkMsg extends Msg {

    private String title;
    private String description;
    private String url;

    public LinkMsg(long msgId, String toUserName, String fromUserName, String title, String description, String url) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), title, description, url);
    }

    public LinkMsg(long msgId, String toUserName, String fromUserName, int createTime, String title, String description, String url) {
        super(msgId, MsgType.link, toUserName, fromUserName, createTime);
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
