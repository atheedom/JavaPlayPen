package com.alextheedom.hystrixdemo.demo1;

import com.alextheedom.hystrixdemo.RemoteServiceSimulator;

/**
 * Created by Mariu on 24/07/2016.
 */
public class Client {

    public static void main(String... args) throws InterruptedException {
        new Client().invokeRemote();
    }

    public void invokeRemote() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            final RemoteServiceSimulator svc = new RemoteServiceSimulator();
            String response;
            if (i < 10) {
                response = svc.checkSomething(1000);
            } else {
                response = svc.checkSomething(60000);
            }
            System.out.println(response);
        }
    }
}
