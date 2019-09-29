package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * city model
 *
 * @author lazy cat
 * @since 2019-09-29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class City {

    /**
     * 主键id
     **/
    private int id;

    /**
     * 城市名字
     **/
    private String name;
}
