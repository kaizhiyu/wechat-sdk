package com.wemote.sdk.wechat.domain.msg.send.mass;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: jayon.xu@gmail.com
 */
public class Filter {

    @JSONField(name = "is_to_all")
    private boolean isToAll;
    @JSONField(name = "group_id")
    private String groupId;

    public boolean isToAll() {
        return isToAll;
    }

    public void setIsToAll(boolean isToAll) {
        this.isToAll = isToAll;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
