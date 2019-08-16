package com.aaa.group8.serviceimpl;

import com.aaa.group8.service.GInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GInformationServiceImpl implements GInformationService{

    @Autowired
    private GInformationService gInformationService;

    @Override
    public Map listMation(Integer baid) {
        return gInformationService.listMation(baid);
    }

    @Override
    public Map listmoney(Integer baid) {
        return gInformationService.listmoney(baid);
    }

    @Override
    public Map notmoney(Integer baid) {
        return gInformationService.notmoney(baid);
    }

    @Override
    public int isstatus(Integer baid) {
        return gInformationService.isstatus(baid);
    }

    @Override
    public Map loanmoney(Integer baid) {
        return gInformationService.loanmoney(baid);
    }


}
