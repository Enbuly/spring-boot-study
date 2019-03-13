package com.example.controller;

import com.example.api.ThreadServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzy
 * @since 3-7
 **/
@RestController
public class ThreadController {

    @Autowired
    private ThreadServer threadServer;

    @GetMapping("/testThread")
    public void test() throws Exception {
        threadServer.doTaskOne();
        threadServer.doTaskTwo();
        threadServer.doTaskThree();
    }
}
