package com.aaa.group8.dao;

import com.aaa.group8.entity.MDome;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MDomeDao {
    /**
     * 账单查询方法
     * @param mDome
     * @return
     */
    List<MDome> getAllList(MDome mDome);
}
