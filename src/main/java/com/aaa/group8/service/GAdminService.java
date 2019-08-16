package com.aaa.group8.service;


import com.aaa.group8.entity.GAdmin;

import java.util.List;
import java.util.Map;

/**
 * 用户Admin表的service
 */

public interface GAdminService {

    /**
     * 查用户表的所有数据
     */
    List<GAdmin> getListAll(Map map);

    /**
     * 后台登录
     */
    int tologin(Map map);

    /**
     * 注册
     */
    int create(Map map);

    /**
     * 用户名唯一性效验
     * 通过名字查找用户
     */
    int getUserByname(String username);

    /**
     * 通过用户名查找用户数据
     * @param username
     * @return
     */
    GAdmin getAdminListAll(String username);

    /**
     * 登录手机号效验
     * @param
     * @return
     */
    GAdmin getUserBytel(Map map);

}
