package com.wemote.sdk.wechat.util;

import com.wemote.sdk.wechat.domain.msg.receive.Msg;
import com.wemote.sdk.wechat.domain.msg.receive.TextMsg;
import com.wemote.sdk.wechat.util.xml.XMLUtils;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author: jayon.xu@gmail.com
 */
public class XMLUtilsTest {

    @Test
    public void testToXML() throws Exception {
        Msg msg = new TextMsg(1l, "toUserName", "fromUserName", "text content");

        String msgXMLStr = XMLUtils.toXML(msg);
        System.out.println(msgXMLStr);
    }

    @Test
    public void testToBean() throws Exception {
        String xmlStr = "<xml>\n" +
                "  <MsgId>1</MsgId>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <ToUserName><![CDATA[toUserName]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUserName]]></FromUserName>\n" +
                "  <CreateTime>1436612334</CreateTime>\n" +
                "  <Content><![CDATA[text content]]></Content>\n" +
                "</xml>";
        TextMsg textMsg = XMLUtils.toBean(xmlStr, TextMsg.class);
        assertThat(1l, is(textMsg.getMsgId()));
    }
}