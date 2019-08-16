package com.aaa.group8.entity;

public class Role {
    private Integer br_id;
    private String br_name;
    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getBr_id() {
        return br_id;
    }

    public void setBr_id(Integer br_id) {
        this.br_id = br_id;
    }

    public String getBr_name() {
        return br_name;
    }

    public void setBr_name(String br_name) {
        this.br_name = br_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "br_id=" + br_id +
                ", br_name='" + br_name + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
