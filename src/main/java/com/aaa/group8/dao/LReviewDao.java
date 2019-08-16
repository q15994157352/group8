package com.aaa.group8.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface LReviewDao {
    /**
     * 保存法人信息
     * @return
     */
    int saveFaren(Map map);
    /**
     * 保存公司信息
     */
    int saveCompany(Map map);
    /**
     * 保存贷款信息
     */
    int saveLoan(Map map);

    /**
     * 查询公司
     * @param map
     * @return
     */
    List<Map> findCompany(Map map);

    /**
     * 查询用户是否申请过
     * @param ba_id
     * @return
     */
    List<Map> getInfo(Integer ba_id);
}
