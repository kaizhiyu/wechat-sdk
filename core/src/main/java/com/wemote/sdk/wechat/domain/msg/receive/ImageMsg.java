package com.wemote.sdk.wechat.domain.msg.receive;

import com.wemote.sdk.wechat.util.Dates;

/**
 * @author: jayon.xu@gmail.com
 */
public class ImageMsg extends Msg {

    private String picUrl;
    private String mediaId;

    public ImageMsg(long msgId, String toUserName, String fromUserName, String picUrl, String mediaId) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), picUrl, mediaId);
    }

    public ImageMsg(long msgId, String toUserName, String fromUserName, int createTime, String picUrl, String mediaId) {
        super(msgId, MsgType.image, toUserName, fromUserName, createTime);
        this.picUrl = picUrl;
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }
}
