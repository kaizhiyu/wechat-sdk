package com.wemote.sdk.wechat.api;

import com.wemote.sdk.wechat.Const;
import com.wemote.sdk.wechat.api.server.AccessTokenMemServer;
import com.wemote.sdk.wechat.api.server.JsapiTicketMemServer;
import com.wemote.sdk.wechat.api.server.TicketServer;
import com.wemote.sdk.wechat.api.server.TokenServer;
import com.wemote.sdk.wechat.domain.msg.receive.Msg;
import com.wemote.sdk.wechat.domain.msg.send.SendMsgResult;
import com.wemote.sdk.wechat.domain.msg.send.mass.MassMsg;
import com.wemote.sdk.wechat.domain.msg.send.tpl.TplMsg;
import com.wemote.sdk.wechat.domain.msg.send.tpl.TplMsgResult;
import com.wemote.sdk.wechat.shared.kernal.BaseResult;
import com.wemote.sdk.wechat.support.http.client.LocalHttpClient;
import com.wemote.sdk.wechat.util.JSONUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * @author: jayon.xu@gmail.com
 */
public class WechatSDK {

    private Config config;

    private TokenServer tokenServer;

    private TicketServer ticketServer;

    public WechatSDK(final Config config) {
        this.config = config;
        this.tokenServer = AccessTokenMemServer.instance(this.config);
        this.ticketServer = JsapiTicketMemServer.instance(this.config);
    }

    public WechatSDK(Config config, TokenServer tokenServer, TicketServer ticketServer) {
        this.config = config;
        this.tokenServer = tokenServer;
        this.ticketServer = ticketServer;
    }

    /**
     * 获取access_token
     *
     * @return
     */
    public String token() {
        return this.tokenServer.token();
    }

    public String ticket() {
        return this.ticketServer.ticket(token());
    }

    public void dispatch(String xmlRequest) {
        // parse xml request to msg
        // dispatch
    }

    /**
     * 消息发送
     *
     * @param msgJSONStr JSON消息字符
     * @return
     */
    public BaseResult sendCustomMsg(String msgJSONStr) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(Const.JSON_HEADER)
                .setUri(Config.BASE_URI + "/cgi-bin/message/custom/send")
                .addParameter("access_token", this.token())
                .setEntity(new StringEntity(msgJSONStr, Charset.forName(Const.CHARSET)))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 消息发送
     *
     * @param msg
     * @return
     */
    public BaseResult sendCustomMsg(Msg msg) {
        return this.sendCustomMsg(JSONUtils.toJSONString(msg));
    }

    /**
     * 高级群发接口,根据分组进行群发
     *
     * @param msgJSONStr
     * @return
     */
    public SendMsgResult sendAllMassMsg(String msgJSONStr) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setConfig(this.buildRequestConfig())
                .setHeader(Const.JSON_HEADER)
                .setUri(Config.BASE_URI + "/cgi-bin/message/mass/sendall")
                .addParameter("access_token", this.token())
                .setEntity(new StringEntity(msgJSONStr, Charset.forName(Const.CHARSET)))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, SendMsgResult.class);
    }

    /**
     * 高级群发接口,根据分组进行群发
     *
     * @param massMsg 群发消息
     * @return
     */
    public SendMsgResult sendAllMassMsg(MassMsg massMsg) {
        return this.sendAllMassMsg(JSONUtils.toJSONString(massMsg));
    }


    /**
     * 高级群发接口,根据OpenID列表群发
     *
     * @param msgJSONStr
     * @return
     */
    public SendMsgResult sendMassMsg(String msgJSONStr) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setConfig(this.buildRequestConfig())
                .setHeader(Const.JSON_HEADER)
                .setUri(Config.BASE_URI + "/cgi-bin/message/mass/send")
                .addParameter("access_token", this.token())
                .setEntity(new StringEntity(msgJSONStr, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, SendMsgResult.class);
    }

    /**
     * 高级群发接口,根据OpenID列表群发
     *
     * @param massMsg
     * @return
     */
    public SendMsgResult messageMassSend(MassMsg massMsg) {
        return this.sendMassMsg(JSONUtils.toJSONString(massMsg));
    }


    /**
     * 高级群发接口 删除群发
     * 请注意，只有已经发送成功的消息才能删除，删除消息只是将消息的图文详情页失效，
     * 已经收到的用户，还是能在其本地看到消息卡片。
     * 另外，删除群发消息只能删除图文消息和视频消息，其他类型的消息一经发送，无法删除。
     *
     * @param msgId 消息Id
     * @return
     */
    public BaseResult delMassMsg(String msgId) {
        String msgIdJSONStr = "{\"msgid\":" + msgId + "}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setConfig(this.buildRequestConfig())
                .setHeader(Const.JSON_HEADER)
                .setUri(Config.BASE_URI + "/cgi-bin/message/mass/delete")
                .addParameter("access_token", this.token())
                .setEntity(new StringEntity(msgIdJSONStr, Charset.forName(Const.CHARSET)))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 模板消息发送
     *
     * @param tplMsg 模板消息
     * @return
     */
    public TplMsgResult sendTplMsg(TplMsg tplMsg) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setConfig(this.buildRequestConfig())
                .setHeader(Const.JSON_HEADER)
                .setUri(Config.BASE_URI + "/cgi-bin/message/template/send")
                .addParameter("access_token", this.token())
                .setEntity(new StringEntity(JSONUtils.toJSONString(tplMsg), Charset.forName(Const.CHARSET)))
                .build();
        return LocalHttpClient.executeJSONResult(httpUriRequest, TplMsgResult.class);
    }

    private RequestConfig buildRequestConfig() {
        return RequestConfig.custom()
                .setSocketTimeout(this.config.getTimeout())
                .setConnectTimeout(this.config.getConnectTimeout())
                .build();
    }


}
