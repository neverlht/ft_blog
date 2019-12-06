package com.fairyt.base.utils;

/**
 * 分页请求参数
 */
public class PageRequest extends QueryRequest{

    private Integer page;

    private Integer pageSize;

    public PageRequest(){
        this(1,10);
    }

    public PageRequest(Integer page){
        this(page,10);
    }

    public PageRequest(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
