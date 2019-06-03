package com.example.webService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * 发布一个web service
 *
 * @author lazy cat
 * @since 2019-05-07
 **/
@WebService
public class HelloWorld {

    private Logger log = LoggerFactory.getLogger(HelloWorld.class);

    //访问地址：http://localhost:8090/HelloWorld?wsdl
    public static void main(String[] args) {
        System.out.println("server is running");
        String address = "http://localhost:8090/HelloWorld";
        Endpoint.publish(address, new HelloWorld());
    }

    @WebMethod
    public String sayHello(String str) {
        log.info("get Message...");
        return "Hello World! " + str + "!";
    }
}
