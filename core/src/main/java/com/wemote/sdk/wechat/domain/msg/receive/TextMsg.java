package com.wemote.sdk.wechat.domain.msg.receive;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wemote.sdk.wechat.util.Dates;
import com.wemote.sdk.wechat.util.xml.XStreamCDataConverter;

/**
 * @author: jayon.xu@gmail.com
 */
@XStreamAlias("xml")
public class TextMsg extends Msg {

    @XStreamAlias("Content")
    @XStreamConverter(XStreamCDataConverter.class)
    private String content;

    public TextMsg(long msgId, String toUserName, String fromUserName, String content) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), content);
    }

    public TextMsg(long msgId, String toUserName, String fromUserName, int createTime, String content) {
        super(msgId, MsgType.text, toUserName, fromUserName, createTime);
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
