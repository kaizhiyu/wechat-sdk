package com.wemote.sdk.wechat.domain.msg.send;

import com.wemote.sdk.wechat.shared.kernal.BaseResult;

/**
 * @author: jayon.xu@gmail.com
 */
public class SendMsgResult extends BaseResult {

    private String type;

    private String msgId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
