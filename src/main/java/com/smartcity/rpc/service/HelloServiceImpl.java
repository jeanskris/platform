package com.smartcity.rpc.service;


import com.patterncat.rpc.common.annotation.ServiceExporter;

/**
 * Created by patterncat on 2016/4/6.
 */
@ServiceExporter(value = "demoSvr",targetInterface = HelloService.class,debugAddress = "127.0.0.1:9090")
public class HelloServiceImpl implements HelloService{
    public String say(String name) {
        return "hi:"+name;
    }
}
