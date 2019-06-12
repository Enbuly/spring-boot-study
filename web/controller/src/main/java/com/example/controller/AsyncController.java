package com.example.controller;

import com.example.api.ThreadServer;
import com.example.responseVo.ResultVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * thread controller
 *
 * @author lazy cat
 * @since 2019-04-11
 **/
@Api(description = "async controller")
@RestController
@RequestMapping(value = "/async")
public class AsyncController extends BaseController {

    @Resource
    private ThreadServer threadServer;

    @PostMapping("/testAsyncTask")
    public ResultVo testAsyncTask() throws Exception {
        threadServer.doTaskOne();
        threadServer.doTaskTwo();
        threadServer.doTaskThree();
        return ResultVo.success("异步任务执行中...");
    }

    @PostMapping("/testAsyncTackSecond")
    public ResultVo testAsyncTackSecond() throws Exception {
        Future<String> future = threadServer.doTaskFourth();
        return ResultVo.success(future.get());
    }
}
