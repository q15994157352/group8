package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.LLoansinfoDao;
import com.aaa.group8.entity.LInformation;
import com.aaa.group8.service.LloansinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class LloansinfoServiceimpl implements LloansinfoService{

    @Autowired
    private LLoansinfoDao lLoansinfoDao;

    /**
     * 获取所有审核通过对象
     */
    @Override
    public List<Map> getAllReview() {
        return lLoansinfoDao.getAllReview();
    }

    /**
     * 查询已经放款信息
     * @param
     * @return
     */
    @Override
    public List<Map> getListAll() {
        return lLoansinfoDao.getListAll();
    }

    /**
     * 放款并扣除本地银行卡金额
     * @param map
     * @return
     */
    @Override
    public int updateBank(Map map) {
        return lLoansinfoDao.updateBank(map);
    }


    /**
     * 放款并增加客户银行卡金额
     * @param map
     * @return
     */
    @Override
    public int updateMoney(Map map) {
        return lLoansinfoDao.updateMoney(map);
    }


    /**
     * 放款修改状态码
     * @param map
     * @return
     */
    @Override
    public int updateStatus(Map map) {
        return lLoansinfoDao.updateStatus(map);
    }

    /**
     * 查询资金明细信息
     * @return
     */
    @Override
    public List<Map> getTurn() {
        return lLoansinfoDao.getTurn();
    }

    /**
     * 放款资金流水明细
     * @param map
     * @return
     */
    @Override
    public int addZhang(Map map) {
        return lLoansinfoDao.addZhang(map);
    }

    /**
     * 获取用户id
     * @param bci_id
     * @return
     */
    @Override
    public int getId(Integer bci_id) {
        return lLoansinfoDao.getId(bci_id);
    }

    /**
     * 获取公司余额
     * @param
     * @return
     */
    @Override
    public Double getMoney() {
        return lLoansinfoDao.getMoney();
    }
}
