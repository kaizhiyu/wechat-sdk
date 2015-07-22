package com.wemote.sdk.wechat.api;

import com.wemote.sdk.wechat.api.support.XMLReceiveMsgType;
import com.wemote.sdk.wechat.api.util.ConfigUtils;
import com.wemote.sdk.wechat.domain.msg.receive.MsgType;
import com.wemote.sdk.wechat.util.xml.XMLUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author: jayon.xu@gmail.com
 */
public class WechatSDKTest {

    private WechatSDK wechatSDK;

    @Before
    public void setUp() throws Exception {
        String appId = ConfigUtils.getAppId();
        String appSecret = ConfigUtils.getAppSecret();
        String token = ConfigUtils.getToken();
        this.wechatSDK = new WechatSDK(new Config(appId, appSecret, token));
    }

    @After
    public void tearDown() throws Exception {
        this.wechatSDK = null;
    }

    @Test
    public void token_shouldReturnSuccess() throws Exception {
        String token = this.wechatSDK.token();
        Assert.assertNotNull(token);
    }

    @Test
    public void parseMsgType_shouldSuccess() throws Exception {
        String xmlStr = "<xml>\n" +
                "  <MsgId>1</MsgId>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <ToUserName><![CDATA[toUserName]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUserName]]></FromUserName>\n" +
                "  <CreateTime>1436612334</CreateTime>\n" +
                "  <Content><![CDATA[text content]]></Content>\n" +
                "</xml>";
        XMLReceiveMsgType xmlReceiveMsgType = XMLUtils.toBean(xmlStr, XMLReceiveMsgType.class);
        assertThat(MsgType.text, is(xmlReceiveMsgType.getMsgType()));
    }
}