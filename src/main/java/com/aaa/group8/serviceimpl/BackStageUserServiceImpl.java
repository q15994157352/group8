package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.PBackstageUserDao;
import com.aaa.group8.entity.Role;
import com.aaa.group8.entity.User;
import com.aaa.group8.service.PBacksSageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class BackStageUserServiceImpl  implements PBacksSageUserService {
@Autowired
private PBackstageUserDao bsudao;
    @Override
    /*
    * 根据参数查询员工
    * */
    public List<User> getListByParam(Map map) {
        return bsudao.getListByParam(map);
    }

    @Override
    public List<User> getPageByParam(Map map) {
        return bsudao.getPageByParam(map);
    }

    @Override
    public int getPageCount(Map map) {
        return bsudao.getPageCount(map);
    }

    /*
    * 保存员工
    * */
    @Override
    public int save(User user) {
        return bsudao.save(user);
    }
/*
* 修改员工
* */
    @Override
    public int update(User user) {
        return bsudao.update(user);
    }
/*
* 删除员工
* */
    @Override
    public int delete(int bu_id) {
        return bsudao.delete(bu_id);
    }

    @Override
    public List<Map> getAllRole() {
        return bsudao.getAllRole();
    }
}
