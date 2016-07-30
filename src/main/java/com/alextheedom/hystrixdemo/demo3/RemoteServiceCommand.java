package com.alextheedom.hystrixdemo.demo3;

import com.alextheedom.hystrixdemo.RemoteServiceSimulator;
import com.netflix.hystrix.HystrixCommand;


public class RemoteServiceCommand extends HystrixCommand<String> {

    private final RemoteServiceSimulator remoteSvc;

    public RemoteServiceCommand(Setter config, RemoteServiceSimulator remoteSvc) {
        super(config);
        this.remoteSvc = remoteSvc;
    }

    @Override
    protected String run() throws Exception {
        return remoteSvc.checkSomething(59999);
    }
}
