package com.wemote.sdk.wechat.api.support;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wemote.sdk.wechat.domain.msg.receive.MsgType;

/**
 * @author: jayon.xu@gmail.com
 */
@XStreamAlias("xml")
public class XMLReceiveMsgType {
    @XStreamAlias("MsgType")
    private MsgType msgType;

    public XMLReceiveMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public MsgType getMsgType() {
        return msgType;
    }
}
