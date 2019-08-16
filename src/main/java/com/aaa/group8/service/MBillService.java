package com.aaa.group8.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 查询账单业务逻辑层
 */

public interface MBillService {
    /**
     * 查询所有流水账单
     * @param
     * @return
     */
    List<Map> getAllList(Integer ba_id);
}
