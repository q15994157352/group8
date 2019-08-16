package com.aaa.group8.controller;

import com.aaa.group8.entity.User;
import com.aaa.group8.service.PBacksSageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class PBackStageUserController {
     @Autowired
    private PBacksSageUserService bssus;
     @RequestMapping("listUser")
     public  Object listByParam(@RequestParam Map map){
         return bssus.getListByParam(map);
     }
    /**
     * 根据参数查询员工列表
     * @param map
     * @return
     */
    @RequestMapping("page")
    public Object pageByParam(@RequestBody Map map){
        System.out.println(map+"接收到的参数");
        //分页数据
        List<User> pageList = bssus.getPageByParam(map);
        //分页总数量
        int pageCount = bssus.getPageCount(map);
        Map mapResult = new HashMap();
        mapResult.put("pageList",pageList);
        mapResult.put("pageCount",pageCount);
        return mapResult;
    }

     /**
     * 添加后台用户
     * @param user
     * @return
     */
     @RequestMapping("saveUser")
    public Object saveUser(@RequestBody  User user){
         System.out.println(user);
         return bssus.save(user);
     }
    /**
     *删除用户
     */
    @RequestMapping("deleteUser")
    public  Object deleteUser(Integer bu_id){
        return bssus.delete(bu_id);
    }
    /**
     * 更改用户信息
     */
    @RequestMapping("updateUser")
    public  Object update(@RequestBody User user){
        return bssus.update(user);
    }

    @RequestMapping("roleList")
    public  Object roleList(){
        return  bssus.getAllRole();
    }
}
