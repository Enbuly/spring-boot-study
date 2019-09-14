package com.example.controller;

import com.example.api.BatchService;
import com.example.model.Batch;
import com.example.responseVo.ResultVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * batch controller
 *
 * @author lazy cat
 * @since 2019-09-14
 **/
@Api(description = "batch controller")
@RestController
@RequestMapping(value = "/batch")
public class BatchController {

    @Resource
    private BatchService batchService;

    private Logger log = LoggerFactory.getLogger(BatchController.class);

    @PostMapping("/testBatchInsert")
    public ResultVo testBatchInsert() {
        List<Batch> list = new ArrayList<>();
        list.add(new Batch("1", "zzy", "13828831312"));
        list.add(new Batch("2", "zzx", "15602227266"));
        int result = batchService.batchInsert(list);
        log.info("批量新增数据成功，成功条数为" + result);
        return ResultVo.success("批量新增数据成功，成功条数为" + result);
    }
}