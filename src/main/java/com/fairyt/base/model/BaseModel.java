package com.fairyt.base.model;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseModel implements Serializable{
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Boolean dr = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDr() {
        return dr;
    }

    public void setDr(Boolean dr) {
        this.dr = dr;
    }

}
