package com.fairyt.base.utils;

import com.fairyt.base.model.BaseModel;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private Integer page = 1;

    private Long total = 0L;

    private Integer pageSize = 10;

    private List<T> data = new ArrayList<>();

    public Page(PageInfo<T> pageInfo) {
        this.page = pageInfo.getPageNum();
        this.total = pageInfo.getTotal();
        this.pageSize = pageInfo.getPageSize();
        this.data = pageInfo.getList();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

