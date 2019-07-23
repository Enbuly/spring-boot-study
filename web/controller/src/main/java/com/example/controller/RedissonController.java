//package com.example.controller;
//
//import com.example.responseVo.ResultVo;
//import io.swagger.annotations.Api;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//@Api(description = "redisson Controller")
//@RestController
//@RequestMapping(value = "/redLock")
//public class RedissonController extends BaseController {
//
//    @Resource
//    private RedissonClient redissonClient;
//
//    private Logger log = LoggerFactory.getLogger(RedissonController.class);
//
//    /**
//     * redis集群模式下的分布式锁的实现
//     **/
//    @GetMapping(value = "/testRedLock")
//    public ResultVo testRedLock() {
//        RLock lock = redissonClient.getLock("anyLock");
//        lock.lock(2, TimeUnit.MINUTES);
//        log.info("lock it success!");
//        lock.unlock();
//        return ResultVo.success("lock success!>>>unlock success!");
//    }
//}
