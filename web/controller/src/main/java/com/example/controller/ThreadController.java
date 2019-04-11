package com.example.controller;

import com.example.api.ThreadServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@RestController
public class ThreadController extends BaseController {

    @Autowired
    private ThreadServer threadServer;

    @PostMapping("/testThread")
    public void test() throws Exception {
        threadServer.doTaskOne();
        threadServer.doTaskTwo();
        threadServer.doTaskThree();
    }
}
