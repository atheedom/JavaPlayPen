package com.alextheedom.hystrixdemo;

/**
 * Created by Mariu on 24/07/2016.
 */
public class RemoteServiceSimulator {

    public String checkSomething(final long timeout) throws InterruptedException {

        System.out.print(String.format("Waiting %sms. ", timeout));

        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException();
        }
        // to simulate a real world delay in processing.
        Thread.sleep(timeout);

        return "Done waiting.";
    }
}
