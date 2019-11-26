package com.fairyt.blog.model;

import com.fairyt.base.model.BaseModel;

import javax.persistence.Table;

@Table(name="ft_blog_category")
public class CategoryModel extends BaseModel {
    //分类名称
    private String name;

    //分类编码
    private String code;

    //父级分类
    private Long parentId;

    //排序
    private Integer sort;

    //备注
    private String remark;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
