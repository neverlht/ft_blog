package com.fairyt.base.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryOn {
    private List<QueryItem> conditions = new ArrayList<>();

    public List<QueryItem> getConditions() {
        return conditions;
    }

    public void setConditions(List<QueryItem> conditions) {
        this.conditions = conditions;
    }

    public static QueryOn build(QueryItem ... items){
        QueryOn on = new QueryOn();
        on.setConditions(Arrays.asList(items));
        return on;
    }
}
