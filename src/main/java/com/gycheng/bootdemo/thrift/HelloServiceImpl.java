package com.gycheng.bootdemo.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements Hello.Iface {

    private Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String helloString(String param) throws TException {
        return "Hello:" + param;
    }

    public void startServer() {
        logger.info("thrift service start");
        try {
            // 创建 TProcessor
            TProcessor tProcessor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());

            // 创建 TServerTransport, TServerSocket 继承于 TServerTransport
            TServerSocket tServerSocket = new TServerSocket(9898);

            // 创建 TProtocol
            TProtocolFactory protocolFactory = new TBinaryProtocol.Factory();

            TServer.Args tArgs = new TServer.Args(tServerSocket);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(protocolFactory);

            // 创建 TServer
            TServer server = new TSimpleServer(tArgs);

            //启动 Server
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
