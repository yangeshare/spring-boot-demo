package com.gycheng.bootdemo;

public class DemoServer {
    private static DemoServer ourInstance = new DemoServer();

    public static DemoServer getInstance() {
        return ourInstance;
    }

    private DemoServer() {
    }

    public void startUp(){
//        HelloServiceImpl helloService = new HelloServiceImpl();
//        helloService.startServer();

    }
}
