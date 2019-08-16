package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.PsysMsgDao;
import com.aaa.group8.service.PsysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PsysMsgServiceImpl implements PsysMsgService{
    @Autowired
    private PsysMsgDao psysMsgDao;
    /**
     * 添加系统消息
     * @param
     * @param
     * @param
     */
    @Override
    public void addSystMeg(Map  map) {
        psysMsgDao.addSystMeg(map);
    }

    /**
     * 获取所有信息
     * @param map
     * @return
     */
    @Override
    public List<Map> getAllMessage(Map map) {
        return psysMsgDao.getAllMessage(map);
    }

    /**
     * 删除一条系统信息
     * @param bs_id
     * @return
     */

    @Override
    public int delMessage(int bs_id) {
        return psysMsgDao.delMessage(bs_id);
    }

    /**
     * 修改信息状态 未读改为已读
     * @param ba_id
     * @return
     */

    @Override
    public int updateMessage(int ba_id) {
        return psysMsgDao.updateMessage(ba_id);
    }

    /**
     * 获取未读消息数量
     * @param ba_id
     * @return
     */
    @Override
    public int getUAllMessage(int ba_id) {
        return psysMsgDao.getUAllMessage(ba_id);
    }

    /**
     * 获取当前客户收到系统消息总数量
     * @param map
     * @return
     */
    @Override
    public int getTotal(Map map ) {

        return psysMsgDao.getTotal(map);
    }
}
