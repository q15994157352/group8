package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.GAdminDao;
import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户表Admin的实现类
 */
@Service
public class GAdminServiceImpl implements GAdminService{

    @Autowired
    private GAdminDao gAdminDao;

    /**
     * 查询用户表的所有数据
     * @param map
     * @return
     */
    @Override
    public List<GAdmin> getListAll(Map map) {
        return gAdminDao.getListAll(map);
    }

    /**
     * 后台登录
     * @param map
     * @return
     */
    @Override
    public int tologin(Map map) {
        return gAdminDao.tologin(map);
    }

    /**
     * 注册
     * @param map
     * @return
     */
    @Override
    public int create(Map map) {
        return gAdminDao.create(map);
    }

    /**
     * 用户名唯一性效验
     * 通过用户名查询所有数据
     * @param username
     * @return
     */
    @Override
    public int getUserByname(String username) {
        return gAdminDao.getUserByname(username);
    }

    @Override
    public GAdmin getAdminListAll(String username) {
        return gAdminDao.getAdminListAll(username);
    }

    @Override
    public GAdmin getUserBytel(Map map) {
        return gAdminDao.getUserBytel(map);
    }
}
