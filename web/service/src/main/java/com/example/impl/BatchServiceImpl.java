package com.example.impl;

import com.example.api.BatchService;
import com.example.mapper.BatchMapper;
import com.example.model.Batch;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 批量处理服务实现
 *
 * @author lazy cat
 * @since 2019-09-14
 **/
@Service
public class BatchServiceImpl implements BatchService {

    @Resource
    private BatchMapper batchMapper;

    /**
     * 批量新增
     **/
    public int batchInsert(List<Batch> batch) {
        return batchMapper.batchInsert(batch);
    }
}
