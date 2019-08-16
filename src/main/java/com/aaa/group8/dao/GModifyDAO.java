package com.aaa.group8.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 前端用户修改
 */
@Repository
public interface GModifyDAO {

//    查找需要修改的用户数据
    Map listAllUser(Integer id);

//    根据用户id修改用户表数据
    int updateuser(Map map);

//    根据用户id修改个人用户信息
    int updatecompany(Map map);



}
