package com.alextheedom.websocket.infrastructure;

@FunctionalInterface
public interface MessageListener<T> {
    void onMessage(T message);
}
