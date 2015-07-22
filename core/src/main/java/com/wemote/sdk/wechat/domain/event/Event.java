package com.wemote.sdk.wechat.domain.event;

import com.google.common.base.Objects;
import com.wemote.sdk.wechat.domain.msg.receive.MsgType;

import java.io.Serializable;

/**
 * @author: jayon.xu@gmail.com
 */
public class Event implements Serializable {

    private MsgType msgType = MsgType.event;
    private String toUserName;
    private String fromUserName;
    private int createTime;
    private EventType event;
    private String eventKey;
    private String ticket;

    public Event(String toUserName, String fromUserName, int createTime, EventType event, String eventKey, String ticket) {
        this.toUserName = toUserName;
        this.fromUserName = fromUserName;
        this.createTime = createTime;
        this.event = event;
        this.eventKey = eventKey;
        this.ticket = ticket;
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

    public EventType getEvent() {
        return event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equal(createTime, event.createTime) &&
                Objects.equal(fromUserName, event.fromUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fromUserName, createTime);
    }
}
