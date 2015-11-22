package com.alextheedom.websocket.infrastructure;

@FunctionalInterface
public interface MessageHandler<T> {
    T processMessage(String message);
}
