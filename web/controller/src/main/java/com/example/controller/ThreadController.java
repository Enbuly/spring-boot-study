package com.example.controller;

import com.example.api.ThreadServer;
import com.example.responseVo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * thread controller
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@RestController(value = "/thread")
public class ThreadController extends BaseController {

    @Resource
    private ThreadServer threadServer;

    @PostMapping("/testThread")
    public ResultVo test() throws Exception {
        threadServer.doTaskOne();
        threadServer.doTaskTwo();
        threadServer.doTaskThree();
        return ResultVo.success("异步任务执行中...");
    }
}
