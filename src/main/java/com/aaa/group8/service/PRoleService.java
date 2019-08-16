package com.aaa.group8.service;

import com.aaa.group8.entity.TreeNode;
import org.apache.ibatis.annotations.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface PRoleService {
    /**
     * 获取所有角色
     *
     * @param
     * @return
     */
    List<TreeNode> getPowers();

    /**
     * 根据id查询
     *
     * @param roleId
     * @return
     */
    TreeNode getPowerById(int roleId);

    /**
     * 添加
     *
     * @param treeNode
     * @return
     */
    int save(TreeNode treeNode, HttpSession session);

    /**
     * 更新
     *
     * @param treeNode
     * @return
     */
    int update(TreeNode treeNode);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int delete(int id);


    /**
     * 根据角色ID查询以前该角色关联的所有权限
     *
     * @param roleId
     * @return
     */

    List<Integer> getPowersByRoleId(int roleId);

    /**
     * 根据用户id获取角色集合
     *
     * @param userId
     * @return
     */

    List<Integer> getRolesByUserId(int userId);

//    List<Role> listRole(Map map);
//    /**
//     * 添加用户角色
//     * @param Role
//     * @return
//     */
//    int saveRole(Role role);
//    /*
//    * 更新用户角色
//    * */
//    int updateRole(Role role);
//    /*
//     *删除用户角色
//     **/
//    int deleteRole(int br_id);

}
