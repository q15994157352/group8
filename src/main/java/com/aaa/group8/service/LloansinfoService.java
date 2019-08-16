package com.aaa.group8.service;



import java.util.List;
import java.util.Map;

public interface LloansinfoService {
    /**
     * 获取所有审核通过对象
     * @return
     */
    List<Map> getAllReview();

    /**
     * 查询已经放款信息
     * @return
     */
    List<Map> getListAll();

    /***
     * 放款并扣除本公司银行卡金额
     */
    int updateBank(Map map);

    /**
     * 放款并增加客户公司银行卡金额
     * @param map
     * @return
     */
    int updateMoney(Map map);

    /**
     * 放款修改状态码
     * @param map
     * @return
     */
    int updateStatus(Map map);

    /**
     * 查询资金明细信息
     * @return
     */
    List<Map> getTurn();

    /**
     * 放款资金流水明细
     * @param map
     * @return
     */
    int  addZhang(Map map);
    /**
     * 获取用户id
     * @return
     */
    int getId(Integer bci_id);

    /**
     * 获取银行卡金额
     * @param
     * @return
     */
    Double getMoney();
}
