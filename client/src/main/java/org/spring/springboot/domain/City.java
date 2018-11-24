package org.spring.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangzy
 * @email 120157229@qq.com
 * @since 11-21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City implements Serializable {

    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;
}
