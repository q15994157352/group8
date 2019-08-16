package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.MBillDao;
import com.aaa.group8.service.MBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 账单业务逻辑层
 */
@Service
public class MBillServiceImpl implements MBillService {

    @Autowired
    private MBillDao billDao;
    /**
     * 查询所有账单
     * @param
     * @return
     */
    @Override
    public List<Map> getAllList(Integer ba_id) {
        return billDao.getAllList(ba_id);
    }
}
