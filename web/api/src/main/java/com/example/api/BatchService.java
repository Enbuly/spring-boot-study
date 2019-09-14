package com.example.api;

import com.example.model.Batch;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 批量处理Service
 **/
@Service
public interface BatchService {

    /**
     * 批量新增
     **/
    int batchInsert(List<Batch> batch);
}