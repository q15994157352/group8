package com.aaa.group8.service;

import com.aaa.group8.entity.TreeNode;

import java.util.List;
import java.util.Map;

public interface PPowerService {
//    获取所有
    List<TreeNode> getPowerTreeData();
    Map toLogin(Map map);
    /**
     * 根据id获取对象
     * @param nodeId
     * @return
     */
    TreeNode getById(int nodeId);

    /**
     * 增加权限
     */
    int savePower(TreeNode treeNode);

    /**
     * 删除权限
     */
    int deletePower(int nodeId);

    /**
     * 修改权限
     */
    int updatePower(TreeNode treeNode);

    List<TreeNode> getLists(Map map);
}
