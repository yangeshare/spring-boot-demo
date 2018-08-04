package com.gycheng.bootdemo.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThriftClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(ThriftClientApplication.class);

    public static void main(String[] args) {
        logger.info("thrift client start");
        //1、创建 Transport
        TTransport transport  = new TSocket("localhost", 9898, 30000);

        //2、创建 Protocol
        TProtocol protocol = new TBinaryProtocol(transport );

        //3、基于 Potocol 创建 Client
        Hello.Client client = new Hello.Client(protocol);
        try {
            //4、打开 Transport
            transport .open();

            //5、调用服务相应的方法.
           String result = client.helloString("gycheng");

            logger.info(String.format("RPC result is: %s", result));
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if(transport  != null){
                transport .close();
            }
        }
    }
}
