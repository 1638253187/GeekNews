package com.windhang.geeknews.bean;

public class QueryBean {
    private String query;
    private int type;

    public QueryBean(String query, int type) {
        this.query = query;
        this.type = type;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
