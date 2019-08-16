package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.ErChartsDao;
import com.aaa.group8.service.ErChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ErChartsServiceImpl implements ErChartsService {
    @Autowired
    private ErChartsDao erChartsDao;

    @Override
    public List<Map> getData(Map map) {
        return erChartsDao.getData(map);
    }
}
