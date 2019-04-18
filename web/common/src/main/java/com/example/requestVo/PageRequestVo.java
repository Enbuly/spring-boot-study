package com.example.requestVo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页请求请求包
 *
 * @author zhangzhenyan
 * @since 2019-04-11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestVo {

    /**
     * 当前页
     **/
    @ApiModelProperty(value = "currentPage")
    @JsonProperty(value = "current_page")
    private int currentPage;

    /**
     * 每页显示的总条数
     **/
    @ApiModelProperty(value = "pageSize")
    @JsonProperty(value = "page_size")
    private int pageSize;
}
