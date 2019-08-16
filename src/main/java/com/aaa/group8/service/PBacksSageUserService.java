package com.aaa.group8.service;

import com.aaa.group8.entity.Role;
import com.aaa.group8.entity.User;

import java.util.List;
import java.util.Map;

public interface PBacksSageUserService {

    /*
    * 根据参数查询列表后台用户，如果参数为空，查询全部
    * */
    List<User> getListByParam(Map map);
    /**
     * 根据参数查询分页列表
     * @param map
     * @return
     */
    List<User>  getPageByParam(Map map);


    /**
     * 获取分页查询到的总条数
     * @param map
     * @return
     */
    int  getPageCount(Map map);
    /*
    *保存
    * */
    int save(User user);
    /*
    * 更新
    * */
    int update(User user);
    /*
     *删除
     **/
    int delete(int bu_id);
    /**
     * 查询所有角色权限
     * @param
     * @return
     */
    List<Map>getAllRole();
}
