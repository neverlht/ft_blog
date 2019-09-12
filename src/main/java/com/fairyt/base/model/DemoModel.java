package com.fairyt.base.model;

import javax.persistence.Table;

@Table(name="demo")
public class DemoModel extends BaseModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
