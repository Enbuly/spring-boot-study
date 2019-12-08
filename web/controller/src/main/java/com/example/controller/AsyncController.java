package com.example.controller;

import com.example.annotation.aopLog.Loggable;
import com.example.api.ThreadServer;
import com.example.responseVo.ResultVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
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
@Loggable(loggable = true)
public class AsyncController extends BaseController {

    @Resource
    private ThreadServer threadServer;

    @Resource
    private KafkaTemplate<Integer, String> kafkaTemplate;

    private Logger log = LoggerFactory.getLogger(AsyncController.class);

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

    /**
     * 测试前需要开启zookeeper服务和kafka服务,打开kafkaListener
     **/
    @PostMapping("/testKafka")
    public ResultVo testKafka(String data) {
        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("hello", data);
        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            public void onFailure(Throwable throwable) {
                log.info("send fail!");
            }

            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {
                log.info("send success!");
            }
        });
        return ResultVo.success("send success! data:" + data);
    }
}
