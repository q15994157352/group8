package com.aaa.group8.service;

import java.util.List;
import java.util.Map;

public interface LRechargeService {
    /**
     * 获取前台还款信息
     * @return
     */
    List<Map> getInfo(Integer ba_id);

    /**
     * 客户公司账户金额充值
     * @param map
     * @return
     */
    int toUpdate(Map map);

    /**
     * 提现减少用户金额
     * @param
     * @return
     */
    int infoUpdate(Map map);

    /**
     * 提现到客户银行卡
     * @param map
     * @return
     */
    int forUpdate(Map map);

    /**
     * 查询用户账号金额
     * @return
     */
    List<Map> findUserMoney(Integer bci_id);

    /**
     * 客户账户金额减少
     * @param map
     * @return
     */
    int getUpdate(Map map);
    /**
     * 自己公司账户金额增加
     * @param map
     * @return
     */
    int myUpdate(Map map);
    /**
     * 还款信息添加
     * @param map
     * @return
     */
    int myAdd(Map map);

    /**
     * 查询已经还款信息
     * @return
     */
    List<Map> getListAll();
}
