package com.alextheedom.websocket.service;

import com.alextheedom.websocket.infrastructure.ClientEndpoint;

/**
 * Created by Developer on 22/11/2015.
 */
public class Dashboard {


    public static void main(String... args) throws InterruptedException {


        ClientEndpoint<String> userEndpoint = ClientEndpoint.createPassthroughEndpoint("ws://localhost:8093/users/");
        userEndpoint.addListener(new LeaderboardData());
        userEndpoint.connect();


        Thread.sleep(10000000);
    }


}
