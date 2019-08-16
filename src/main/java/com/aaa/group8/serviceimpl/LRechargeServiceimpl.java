package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.LRechargeDao;
import com.aaa.group8.service.LRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class LRechargeServiceimpl implements LRechargeService {
    @Autowired
    private LRechargeDao lRechargeDao;
    /**
     * 获取应还款信息
     * @return
     */
    @Override
    public List<Map> getInfo(Integer ba_id) {
        return lRechargeDao.getInfo(ba_id);
    }

    /**
     * 客户账户金额充值
     * @param map
     * @return
     */
    @Override
    public int toUpdate(Map map) {
        return lRechargeDao.toUpdate(map);
    }

    /**
     * 提现减少用户金额
     * @param
     * @return
     */
    @Override
    public int infoUpdate(Map map) {
        return lRechargeDao.infoUpdate(map);
    }

    /**
     * 体现到客户公司银行卡
     * @param map
     * @return
     */
    @Override
    public int forUpdate(Map map) {
        return lRechargeDao.forUpdate(map);
    }

    /**
     * 查询用户账户金额
     * @return
     */
    @Override
    public List<Map> findUserMoney(Integer bci_id) {
        return lRechargeDao.findUserMoney(bci_id);
    }

    /**
     * 客户账户减少
     * @param map
     * @return
     */
    @Override
    public int getUpdate(Map map) {
        return lRechargeDao.getUpdate(map);
    }

    /**
     * 自己公司账户增加
     * @param map
     * @return
     */
    @Override
    public int myUpdate(Map map) {
        return lRechargeDao.myUpdate(map);
    }

    /**
     * 还款信息添加
     * @param map
     * @return
     */
    @Override
    public int myAdd(Map map) {
        return lRechargeDao.myAdd(map);
    }
    /**
     * 查询已经还款信息
     * @return
     */
    @Override
    public List<Map> getListAll() {
        return lRechargeDao.getListAll();
    }
}
