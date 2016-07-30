package com.alextheedom.hystrixdemo.demo3;

import com.alextheedom.hystrixdemo.RemoteServiceSimulator;
import com.alextheedom.hystrixdemo.demo3.RemoteServiceCommand;
import com.netflix.hystrix.*;

public class HystrixClient {

    private static HystrixCommand.Setter config;

    public static void main(String... args) throws InterruptedException {
        setup();
        String response = new RemoteServiceCommand(config, new RemoteServiceSimulator()).execute();
        System.out.println(response);
    }

    private static void setup() {

        config = HystrixCommand
                .Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup1"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("RemoteServiceKey1"));

        final HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();

        commandProperties
                .withCircuitBreakerSleepWindowInMilliseconds(60000)
                .withExecutionTimeoutInMilliseconds(1000)
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);

        config.andCommandPropertiesDefaults(commandProperties);

        config.andThreadPoolPropertiesDefaults(
                HystrixThreadPoolProperties
                        .Setter()
                        .withCoreSize(10)
                        .withQueueSizeRejectionThreshold(5));
    }

}
