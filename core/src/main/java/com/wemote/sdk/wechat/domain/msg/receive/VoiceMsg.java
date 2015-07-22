package com.wemote.sdk.wechat.domain.msg.receive;

import com.wemote.sdk.wechat.util.Dates;

/**
 * @author: jayon.xu@gmail.com
 */
public class VoiceMsg extends Msg {

    private String mediaId;
    private String format;
    private String recognition;

    public VoiceMsg(long msgId, String toUserName, String fromUserName, String mediaId, String format, String recognition) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), mediaId, format, recognition);
    }

    public VoiceMsg(long msgId, String toUserName, String fromUserName, int createTime, String mediaId, String format, String recognition) {
        super(msgId, MsgType.voice, toUserName, fromUserName, createTime);
        this.mediaId = mediaId;
        this.format = format;
        this.recognition = recognition;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getFormat() {
        return format;
    }

    public String getRecognition() {
        return recognition;
    }
}
