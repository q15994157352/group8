package com.aaa.group8.service;

import java.util.List;
import java.util.Map;

public interface LremoneyService {
    /**
     * 查询所有未还款用户
     * @param ba_id
     * @return
     */
    List<Map> getAll(Integer ba_id);
    /**
     * 查询客户账户公司金额
     * @param bci_id
     * @return
     */
    Map findMoney(Integer bci_id);

    /**
     * 还款扣除客户公司金额
     * @param map
     * @return
     */
    int updateCompanyMoney(Map map);

    /**
     * 还款增加自己公司金额
     * @param map
     * @return
     */
    int updateBAnkcard(Map map);

    /**
     * 还款修改贷款状态
     * @param map
     * @return
     */
    int updateStatus(Map map);

    /**
     * 添加已还款信息
     * @return
     */
    int addRemoney(Map map);

    /**
     * 查询还款状态
     * @param map
     * @return
     */
    List<Map> getStatus(Map map);

    /**
     * 查询已还款信息
     * @param ba_id
     * @return
     */
    List<Map> getRemoneyList(Integer ba_id);

    /**
     * 还款资金流水明细
     * @param map
     * @return
     */
    int addHu(Map map);

    /**
     * 查询资金流水明细
     * @return
     */
    List<Map> getAllMing();
}
