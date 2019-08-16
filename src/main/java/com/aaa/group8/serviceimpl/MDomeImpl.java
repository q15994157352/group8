package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.MDomeDao;
import com.aaa.group8.entity.MDome;
import com.aaa.group8.service.MDomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MDomeImpl implements MDomeService {

    @Autowired
    private MDomeDao mDomeDao;


    @Override
    public List<MDome> getAllList(MDome mDome) {
        return mDomeDao.getAllList(mDome);
    }
}

