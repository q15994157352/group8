package com.aaa.group8.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 账单查询接口
 */
@Repository
public interface MBillDao {
    /**
     * 查询所有流水账单
     * @param
     * @return
     */
    List<Map> getAllList(Integer ba_id);
}
