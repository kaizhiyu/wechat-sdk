package com.wemote.sdk.wechat.domain.msg.send.mass;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Set;

/**
 * @author: jayon.xu@gmail.com
 */
public abstract class MassMsg {

    @JSONField(name = "msg_type")
    protected String msgType;
    @JSONField(name = "filter")
    private Filter filter;//用于特定组
    @JSONField(name = "touser")
    private Set<String> toUser;//用于指定用户

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Set<String> getToUser() {
        return toUser;
    }

    public void setToUser(Set<String> toUser) {
        this.toUser = toUser;
    }
}
