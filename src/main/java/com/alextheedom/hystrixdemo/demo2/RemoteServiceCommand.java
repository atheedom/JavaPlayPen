package com.alextheedom.hystrixdemo.demo2;

import com.alextheedom.hystrixdemo.RemoteServiceSimulator;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;


public class RemoteServiceCommand extends HystrixCommand<String> {

    private final RemoteServiceSimulator remoteSvc;

    public RemoteServiceCommand(RemoteServiceSimulator remoteSvc) {
        super(HystrixCommandGroupKey.Factory.asKey("Simulator"));
        this.remoteSvc = remoteSvc;
    }

    @Override
    protected String run() throws Exception {
        return remoteSvc.checkSomething(970);
    }
}
