package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.LEmitDao;
import com.aaa.group8.service.LEmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class LEmitServiceimpl implements LEmitService{
    @Autowired
    private LEmitDao lEmitDao;
    /**
     * 添加放款信息
     * @param map
     * @return
     */
    @Override
    public int addEmit(Map map) {
        return lEmitDao.addEmit(map);
    }
}
