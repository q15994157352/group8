package com.aaa.group8.dao;

import com.aaa.group8.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PBackstageUserDao {

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
    /**
     * 保存
     * @param user
     * @return
     */
 int save(User user);

    /**
     * 更新管理员信息
     * @param user
     * @return
     */
 int update(User user);

    /**
     * 删除管理员
     * @param bu_id
     * @return
     */
 int delete(int bu_id);

    /**
     * 查询所有角色权限
     * @param
     * @return
     */
 List<Map>getAllRole();
}
