package com.wemote.sdk.wechat.domain.msg.send.tpl;

import com.wemote.sdk.wechat.shared.kernal.BaseResult;

public class TplMsgResult extends BaseResult {

    private long msgId;

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
