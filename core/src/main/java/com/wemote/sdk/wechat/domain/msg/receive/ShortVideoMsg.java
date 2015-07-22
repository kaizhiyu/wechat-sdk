package com.wemote.sdk.wechat.domain.msg.receive;

import com.wemote.sdk.wechat.util.Dates;

/**
 * @author: jayon.xu@gmail.com
 */
public class ShortVideoMsg extends Msg {

    private String mediaId;
    private String thumbMediaId;

    public ShortVideoMsg(long msgId, String toUserName, String fromUserName, String mediaId, String thumbMediaId) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), mediaId, thumbMediaId);
    }

    public ShortVideoMsg(long msgId, String toUserName, String fromUserName, int createTime, String mediaId, String thumbMediaId) {
        super(msgId, MsgType.shortvideo, toUserName, fromUserName, createTime);
        this.mediaId = mediaId;
        this.thumbMediaId = thumbMediaId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }
}
