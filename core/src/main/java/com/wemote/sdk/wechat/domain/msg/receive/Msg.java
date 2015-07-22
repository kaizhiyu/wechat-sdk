package com.wemote.sdk.wechat.domain.msg.receive;

import com.google.common.base.Objects;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.wemote.sdk.wechat.util.Dates;
import com.wemote.sdk.wechat.util.xml.XStreamCDataConverter;
import com.wemote.sdk.wechat.util.xml.XStreamEnumToStringConverter;

import java.io.Serializable;

/**
 * @author: jayon.xu@gmail.com
 */
public abstract class Msg implements Serializable {

    @XStreamAlias("MsgId")
    private long msgId;
    @XStreamAlias("MsgType")
    @XStreamConverter(XStreamEnumToStringConverter.class)
    private MsgType msgType;
    @XStreamAlias("ToUserName")
    @XStreamConverter(XStreamCDataConverter.class)
    private String toUserName;
    @XStreamAlias("FromUserName")
    @XStreamConverter(XStreamCDataConverter.class)
    private String fromUserName;
    @XStreamAlias("CreateTime")
    private int createTime;

    public Msg(long msgId, MsgType msgType, String toUserName, String fromUserName) {
        this(msgId, msgType, toUserName, fromUserName, Dates.getCurrentSeconds());
    }

    public Msg(long msgId, MsgType msgType, String toUserName, String fromUserName, int createTime) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Msg)) return false;
        Msg msg = (Msg) o;
        return Objects.equal(msgId, msg.msgId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(msgId);
    }

    public long getMsgId() {
        return msgId;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public String getToUserName() {
        return toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public int getCreateTime() {
        return createTime;
    }
}
