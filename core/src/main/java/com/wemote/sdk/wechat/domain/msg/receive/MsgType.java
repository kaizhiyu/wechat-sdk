package com.wemote.sdk.wechat.domain.msg.receive;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.enums.EnumToStringConverter;

/**
 * @author: jayon.xu@gmail.com
 */
@XStreamConverter(EnumToStringConverter.class)
public enum MsgType {
    unknown,
    event,        //事件
    text,         //文本消息
    image,
    location,
    link,
    voice,
    video,
    shortvideo,
    music,
    news;
}
