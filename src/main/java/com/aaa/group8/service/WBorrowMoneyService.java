package com.aaa.group8.service;


import com.aaa.group8.entity.BorrowMoney;

import java.util.List;
import java.util.Map;

public interface WBorrowMoneyService {
    List<Map> boList();

    /**
     * 查询分页列表
     */
    List<BorrowMoney> getboPaging(Map map);
    /**
     * 获取分页查询的总条数
     */
    int getPagingMap(Map map);

    /**
     * 审核通过
     */
    int update(Map map);
    /**
     * 审核不通过
     *
     */
    int reason(Map map);

    /**
     * 借款审核不通过驳回存历史审核记录
     */
    int rejectMessage(Map map);
    /**
     * 公司审核修改状态
     */
    int updateC(Map map);
    /**
     * 公司审核不通过驳回存历史审核记录
     */
    int rejectMessageA(Map map);
    /**
     * 公司审核通过存历史审核记录
     */
    int passMessage(Map map);
    /**
     * 借款审核通过存历史审核记录
     */
    int passMessageA(Map map);
    /**
     * 借款审核
     */
    List<Map>bsList();
    /**
     * 借款审核分页列表
     */
    List<BorrowMoney> getbePaging(Map map);
    /**
     * 获取借款审核分页查询的总条数
     */
    int getbePagingMap(Map map);
    /**
     * 借款审核通过
     */
    int updateA(Map map);
    /**
     * 借款审核不通过
     *
     */
    int reasonA(Map map);
    /**
     * 第二次借款审核通过

     */
    int updateB(Map map);


    List<BorrowMoney> PagingA(Map map);
    /**
     * 获取借款审核分页查询的总条数A
     */
    int PagingMapA(Map map);
    /**
     * 驳回历史表
     */
    List<BorrowMoney> rejectList();
    /**
     * 驳回分页
     */
    List<BorrowMoney> rejectA(Map map);
    /**
     * 驳回分页总数
     */
    int rejectAMap(Map map);
    /**
     /**
     * 通过历史表
     */
    List<BorrowMoney> passMap();
    /**
     * 通过分页
     */
    List<BorrowMoney> passList(Map map);
    /**
     * 通过分页总数
     */
    int passListA(Map map);


    List<BorrowMoney> reList(Map map);

    int reListA(Map map);

}
