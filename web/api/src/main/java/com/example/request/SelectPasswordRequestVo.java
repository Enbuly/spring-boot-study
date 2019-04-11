package com.example.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectPasswordRequestVo {
    private String name;
    private String phone;
}
