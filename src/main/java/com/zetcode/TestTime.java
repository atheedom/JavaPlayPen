package com.zetcode;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by atheedom on 07/10/15.
 */
public class TestTime {


    private static boolean fruitOnScreen = false;

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                fruitOnScreen = true;
            }
        }, 15, 15, TimeUnit.SECONDS);


    }


}
