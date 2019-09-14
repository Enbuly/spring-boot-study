package com.example.mapper;

import com.example.model.Batch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 批量处理mapper
 *
 * @author lazy cat
 * @since 2019-09-14
 **/
@Mapper
public interface BatchMapper {

    /**
     * 批量新增
     **/
    int batchInsert(List<Batch> batch);
}
