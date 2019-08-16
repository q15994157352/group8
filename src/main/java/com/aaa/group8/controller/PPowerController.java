package com.aaa.group8.controller;


import com.aaa.group8.entity.TreeNode;
import com.aaa.group8.service.PPowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class PPowerController {
    /**
     * 后台登录
     */
    @Autowired(required = false)
    private PPowerService powerService;

    @RequestMapping("/userLogin")
    public int userLogin(@RequestParam Map map, HttpServletRequest request) {
        Map user = powerService.toLogin(map);

        if (user == null || user.size() == 0) {
            return 0;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return 1;
    }

    /**
     * 后台退出
     */
    @RequestMapping("logout")
    public Object logout() {
        return 1;
    }

    /**
     * 获取power tree数据
     *
     * @return
     */
    @RequestMapping("treeList")
    public Object powerList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map user = (Map) session.getAttribute("user");
        if (user == null) {
            return null;
        }
        List<TreeNode> powerList = powerService.getPowerTreeData();
        Map map = new HashMap();
        map.put("powerList", powerList);
        map.put("userName", user.get("BU_USERNAME"));
        return map;
    }

    /**
     * 查询模块
     */
    @RequestMapping("getPowerById")
    public Object getPowerById(Integer nodeId) {
        return powerService.getById(nodeId);
    }

    /**
     * 增加权限模块
     */
    @RequestMapping("savePower")
    public Object savePower(@RequestBody TreeNode treeNode) {
        return powerService.savePower(treeNode);
    }

    /**
     * 删除权限模块
     */
    @RequestMapping("deletePower")
    public Object deletePower(Integer nodeId) {
        //System.out.println(nodeId);
        return powerService.deletePower(nodeId);
    }

    /**
     * 修改权限模块
     */
    @RequestMapping("updatePower")
    public Object updatePower(@RequestBody TreeNode treeNode) {
        return powerService.updatePower(treeNode);
    }


    /**
     * 获取power tree数据
     *
     * @return
     */
    @RequestMapping("treeLists")
    public Object powerLists(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map user = (Map) session.getAttribute("user");
        if (user == null) {
            return null;
        }
        List<TreeNode> powerList = powerService.getLists(user);
        Map map = new HashMap();
        map.put("powerList", powerList);
        map.put("userName", user.get("BU_USERNAME"));
        return map;
    }
}
