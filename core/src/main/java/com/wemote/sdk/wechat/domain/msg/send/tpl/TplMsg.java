package com.wemote.sdk.wechat.domain.msg.send.tpl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.LinkedHashMap;

public class TplMsg {

    @JSONField(name = "touser")
    private String toUser;
    @JSONField(name = "template_id")
    private String tplId;
    @JSONField(name = "url")
    private String url;
    @JSONField(name = "topcolor")
    private String topColor;
    @JSONField(name = "data")
    private LinkedHashMap<String, TplMsgItem> data;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTplId() {
        return tplId;
    }

    public void setTplId(String tplId) {
        this.tplId = tplId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public LinkedHashMap<String, TplMsgItem> getData() {
        return data;
    }

    public void setData(LinkedHashMap<String, TplMsgItem> data) {
        this.data = data;
    }
}
