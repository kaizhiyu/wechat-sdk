package com.wemote.sdk.wechat.domain.msg.receive;

import com.wemote.sdk.wechat.util.Dates;

import java.math.BigDecimal;

/**
 * @author: jayon.xu@gmail.com
 */
public class LocationMsg extends Msg {

    private BigDecimal locationX;
    private BigDecimal locationY;
    private int scale;
    private String label;

    public LocationMsg(long msgId, String toUserName, String fromUserName, BigDecimal locationX, BigDecimal locationY, int scale, String label) {
        this(msgId, toUserName, fromUserName, Dates.getCurrentSeconds(), locationX, locationY, scale, label);
    }

    public LocationMsg(long msgId, String toUserName, String fromUserName, int createTime, BigDecimal locationX, BigDecimal locationY, int scale, String label) {
        super(msgId, MsgType.location, toUserName, fromUserName, createTime);
        this.locationX = locationX;
        this.locationY = locationY;
        this.scale = scale;
        this.label = label;
    }

    public BigDecimal getLocationX() {
        return locationX;
    }

    public BigDecimal getLocationY() {
        return locationY;
    }

    public int getScale() {
        return scale;
    }

    public String getLabel() {
        return label;
    }
}
