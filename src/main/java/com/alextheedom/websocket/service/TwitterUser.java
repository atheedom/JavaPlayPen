package com.alextheedom.websocket.service;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Developer on 22/11/2015.
 */
public class TwitterUser {
    private final SimpleStringProperty twitterHandle = new SimpleStringProperty();
    private final SimpleIntegerProperty tweetCount = new SimpleIntegerProperty(0);
    private AtomicInteger count = new AtomicInteger(0);

    public TwitterUser(String twitterHandle) {
        this.twitterHandle.set(twitterHandle);
    }

    public String getTwitterHandle() {
        return twitterHandle.get();
    }

    public SimpleStringProperty twitterHandleProperty() {
        return twitterHandle;
    }

    public int getTweetCount() {
        return tweetCount.get();
    }

    public SimpleIntegerProperty tweetCountProperty() {
        return tweetCount;
    }

    public int incrementCount() {
        int newValue = count.incrementAndGet();
        tweetCount.set(newValue);
        return newValue;
    }

}
