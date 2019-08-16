package com.aaa.group8.service;

import java.util.Map;

/**
 * 修改用户信息
 */
public interface GModifyService {

    //    查找需要修改的用户数据
    Map listAllUser(Integer id);

    //    根据用户id修改用户表数据
    int updateuser(Map map);

    //    根据用户id修改个人用户信息
    int updatecompany(Map map);

}
