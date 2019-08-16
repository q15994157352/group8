package com.aaa.group8.controller;

import com.aaa.group8.entity.TreeNode;
import com.aaa.group8.service.PRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("role")
public class PRoleController {
    @Autowired
    private PRoleService pRoleService;

    /**
     * 获取角色角色菜单树数据
     * @return
     */
    @RequestMapping("tree")
    public Object tree(){
        return pRoleService.getPowers();
    }

    /**
     * 获取角色根据ID
     * @param powerId
     * @return
     */
    @RequestMapping("getPowerById")
    public Object getPowerById(Integer powerId){
        return pRoleService.getPowerById(powerId);
    }

    /**
     * 添加
     * @param treeNode
     * @return
     */
    @RequestMapping("save")
    public Object save(@RequestBody TreeNode treeNode, HttpSession session){
        return pRoleService.save(treeNode,session);
    }

    /**
     * 更新
     * @param treeNode
     * @return
     */
    @RequestMapping("update")
    public int update(@RequestBody TreeNode treeNode){
        return pRoleService.update(treeNode);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public Object delete(Integer id){
        return pRoleService.delete(id);
    }

    /**
     * 根据角色ID查询以前该角色关联的所有权限
     * @param roleId
     * @return
     */
    @RequestMapping("getPowersByRoleId")
    public Object getPowersByRoleId(Integer roleId){
        return pRoleService.getPowersByRoleId(roleId);
    }

    /**
     * 根据用户ID获取该用户对应的角色列表
     * @return
     */
    @RequestMapping("getRolesByUserId")
    public Object  getRolesByUserId(Integer userId){
        return pRoleService.getRolesByUserId(userId);
    }
}
