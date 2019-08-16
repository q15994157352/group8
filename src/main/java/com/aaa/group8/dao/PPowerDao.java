package com.aaa.group8.dao;

import com.aaa.group8.entity.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PPowerDao {
    //    获取所有
    List<TreeNode> getList();
   /*
   * 后台登录
   * */
    Map toLogin(Map map);

    /**
     * 权限管理
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
