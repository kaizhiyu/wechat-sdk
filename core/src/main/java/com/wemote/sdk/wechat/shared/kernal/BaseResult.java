package com.wemote.sdk.wechat.shared.kernal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author: jayon.xu@gmail.com
 */
public class BaseResult {

    @JSONField(name = "errcode")
    private int errCode;
    @JSONField(name = "errmsg")
    private String errMsg;

    protected BaseResult() {
    }

    public BaseResult(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    @Deprecated
    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Deprecated
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
