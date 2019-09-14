package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * batch_table表model
 *
 * @author lazy cat
 * @since 2019-09-14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {

    /**
     * 主键
     **/
    private String id;

    /**
     * 名字
     **/
    private String name;

    /**
     * 电话号码
     **/
    private String phone;

}
