package com.example.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    /**
     * n
     * name列名
     * orderNum列的排序
     **/
    @Excel(name = "姓名", orderNum = "0")
    private String name;

    /**
     * replace值的替换 导出是{a_id,b_id} 导入反过来
     **/
    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private String sex;

    /**
     * exportFormat导出的时间格式,以这个是否为空来判断是否需要格式化日期
     * importFormat导入的时间格式,以这个是否为空来判断是否需要格式化日期
     **/
    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", importFormat = "yyyy-MM-dd", orderNum = "2")
    private Date birthday;
}
