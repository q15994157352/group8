package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.LReviewDao;
import com.aaa.group8.service.LReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class LReviewServiceImpl implements LReviewService {
    @Autowired
    private LReviewDao reviewDao;
    /**
     * 保存法人信息
     * @return
     */
    @Override
    public int saveFaren(Map map) {
        return reviewDao.saveFaren(map);
    }

    /**
     * 保存公司信息
     */
    @Override
    public int saveCompany(Map map) {
       int i= reviewDao.saveCompany(map);
        return i;
    }

    /**
     * 保存贷款信息
     */
    @Override
    public int saveLoan(Map map) {
        return reviewDao.saveLoan(map);
    }

    /**
     * 查询公司信息
     * @param map
     * @return
     */
    @Override
    public List<Map> findCompany(Map map) {
        return reviewDao.findCompany(map);
    }


    /**
     * 查询用户是否申请过
     * @param ba_id
     * @return
     */
    @Override
    public List<Map> getInfo(Integer ba_id) {
        return reviewDao.getInfo(ba_id);
    }
}
