package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.LremoneyDao;
import com.aaa.group8.service.LremoneyService;
import oracle.sql.DATE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
@Service
public class LremoneyServiceimpl implements LremoneyService{
    @Autowired
    private LremoneyDao lremoneyDao;
    /**
     * 查询所有未还款用户
     * @param ba_id
     * @return
     */
    @Override
    public List<Map> getAll(Integer ba_id) {
        return lremoneyDao.getAll(ba_id);
    }

    /**
     * 查询客户公司金额
     * @param bci_id
     * @return
     */
    @Override
    public Map findMoney(Integer bci_id) {
        return lremoneyDao.findMoney(bci_id);
    }

    /**
     * 还款扣除客户公司银行卡金额
     * @param map
     * @return
     */
    @Override
    public int updateCompanyMoney(Map map) {
        return lremoneyDao.updateCompanyMoney(map);
    }

    /**
     * 还款增加自己公司金额
     * @param map
     * @return
     */
    @Override
    public int updateBAnkcard(Map map) {
        return lremoneyDao.updateBAnkcard(map);
    }

    /**
     * 还款修改贷款状态
     * @param map
     * @return
     */
    @Override
    public int updateStatus(Map map) {
        return lremoneyDao.updateStatus(map);
    }

    /**
     * 添加已还款信息
     * @param map
     * @return
     */
    @Override
    public int addRemoney(Map map) {
        return lremoneyDao.addRemoney(map);
    }

    /**
     * 查询还款状态
     * @param map
     * @return
     */
    @Override
    public List<Map> getStatus(Map map) {
        return lremoneyDao.getStatus(map);
    }

    /**
     * 查询已还款信息
     * @param ba_id
     * @return
     */
    @Override
    public List<Map> getRemoneyList(Integer ba_id) {
        return lremoneyDao.getRemoneyList(ba_id);
    }

    /**
     * 还款资金流水明细
     * @param map
     * @return
     */
    @Override
    public int addHu(Map map) {
        return lremoneyDao.addHu(map);
    }

    /**
     * 查询资金流水明细
     * @return
     */
    @Override
    public List<Map> getAllMing() {
        return lremoneyDao.getAllMing();
    }
}
