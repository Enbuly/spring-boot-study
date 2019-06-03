package com.example.responseVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页请求返回包
 *
 * @author cat
 * @since 2019-04-11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseVo<T> {

    /**
     * 当前页
     **/
    private Integer currentPage = 1;

    /**
     * 每页显示的总条数
     **/
    private Integer pageSize = 10;

    /**
     * 总条数
     **/
    private Integer totalNum;

    /**
     * 是否有下一页
     **/
    private Integer isMore;

    /**
     * 总页数
     **/
    private Integer totalPage;

    /**
     * 分页结果
     **/
    private List<T> items;

    public PageResponseVo(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum + this.pageSize - 1) / this.pageSize;
        this.isMore = this.currentPage >= this.totalPage ? 0 : 1;
    }
}
