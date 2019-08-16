package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.GModifyDAO;
import com.aaa.group8.service.GModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 修改用户信息
 */
@Service
public class GModifyServiceImpl implements GModifyService{

    @Autowired
    private GModifyDAO gModifyDAO;

    @Override
    public Map listAllUser(Integer id) {
        return gModifyDAO.listAllUser(id);
    }

    @Override
    public int updateuser(Map map) {
        return gModifyDAO.updateuser(map);
    }

    @Override
    public int updatecompany(Map map) {
        return gModifyDAO.updatecompany(map);
    }


}
