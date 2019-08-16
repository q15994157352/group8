package com.aaa.group8.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 用户个人信息
 */
@Repository
public interface GInformationDAO {

    /**
     * 取出用户个人信息
     * @return
     */
    Map listMation(Integer baid);

    /**
     * 取出用户已还金额
     */
    Map listmoney(Integer baid);

    /**
     * 取出用户未还金额
     */
    Map notmoney(Integer baid);

    /**
     * 取出用户的状态码
     * @param baid
     * @return
     */
    int isstatus(Integer baid);


    /**
     * 查询用户借款金额
     * @param baid
     * @return
     */
    Map loanmoney(Integer baid);
}
