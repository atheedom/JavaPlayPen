package com.alextheedom.hystrixdemo.demo2;

import com.alextheedom.hystrixdemo.RemoteServiceSimulator;

public class HystrixClient {
    public static void main(String... args) throws InterruptedException {
        String response = new RemoteServiceCommand(new RemoteServiceSimulator()).execute();
        System.out.println(response);
    }
}
