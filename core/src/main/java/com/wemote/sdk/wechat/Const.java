package com.wemote.sdk.wechat;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;

/**
 * @author: jayon.xu@gmail.com
 */
public class Const {

    public static final String NAME = "WeChat sdk for Java";
    public static final String CHARSET = "utf-8";
    //java sdk version
    public static final String VERSION = "v0.1.0";
    public static final String USER_AGENT = "wechat/java sdk " + VERSION;

    public static final Header JSON_HEADER = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    public static final Header XML_HEADER = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_XML.toString());

}
