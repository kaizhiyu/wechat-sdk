package com.wemote.sdk.wechat.domain.event;

/**
 * @param <E> event
 * @author jayon.xu@gmail.com
 */
public interface EventListener<E> {

    void on(E event);
}
