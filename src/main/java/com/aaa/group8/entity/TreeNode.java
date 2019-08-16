package com.aaa.group8.entity;

import java.util.List;

public class TreeNode {
    private Integer  bl_id;
    private Integer br_id;
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    private String  label;
    private Integer  bl_parentId;
    private Integer br_parentId;

    public Integer getBr_parentId() {
        return br_parentId;
    }

    public void setBr_parentId(Integer br_parentId) {
        this.br_parentId = br_parentId;
    }

    private String url;
    private List<TreeNode> children;

    public Integer getBl_id() {
        return bl_id;
    }

    public void setBl_id(Integer bl_id) {
        this.bl_id = bl_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getBl_parentId() {
        return bl_parentId;
    }

    public void setBl_parentId(Integer bl_parentId) {
        this.bl_parentId = bl_parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Integer getBr_id() {
        return br_id;
    }

    public void setBr_id(Integer br_id) {
        this.br_id = br_id;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "bl_id=" + bl_id +
                ", br_id=" + br_id +
                ", parentName='" + parentName + '\'' +
                ", label='" + label + '\'' +
                ", bl_parentId=" + bl_parentId +
                ", br_parentId=" + br_parentId +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}
