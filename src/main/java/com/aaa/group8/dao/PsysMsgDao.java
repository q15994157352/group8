package com.aaa.group8.dao;

import java.util.List;
import java.util.Map;

public interface PsysMsgDao {
    /**
     * 添加系统信息
     * @param
     * @param
     * @param
     */
    public void addSystMeg(Map map);

    /**
     * 获取当前客户所有信息
     * @param map
     * @return
     */
    public List<Map> getAllMessage(Map map);

    /**
     * 删除当前客户一条信息
     * @param bs_id
     * @return
     */
    public int delMessage(int bs_id);

    /**
     * 修改客户信息状态 未读改为已读
     * @param bu_id
     * @return
     */
    public int updateMessage(int bu_id);

    /**
     * 获取当前客户所有未读信息总数
     * @param bu_id
     * @return
     */
    public int getUAllMessage(int bu_id);

    /**
     *  获取当前客户收到系统消息总数
     * @param map
     * @return
     */

    public int getTotal(Map map );
}
