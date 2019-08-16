package com.aaa.group8.serviceimpl;

import com.aaa.group8.dao.WBorrowMoneyDao;
import com.aaa.group8.entity.BorrowMoney;
import com.aaa.group8.service.WBorrowMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WBorrowMoneyServiceImpl implements WBorrowMoneyService {
    @Autowired
    private WBorrowMoneyDao wBorrowMoneyDao;



    @Override
    public List<Map> boList() {
        return wBorrowMoneyDao.boList();
}


    @Override
    public List<BorrowMoney> getboPaging(Map map) {
        return wBorrowMoneyDao.getboPaging(map);
    }
    @Override
    public List<BorrowMoney>rejectA(Map map){
        return wBorrowMoneyDao.rejectA(map);
    }

    @Override
    public int getPagingMap(Map map) {
        return wBorrowMoneyDao.getPagingMap(map);
    }

    @Override
    public int update(Map map) {
        return wBorrowMoneyDao.update(map);
    }

    @Override
    public int reason(Map map) {
        return wBorrowMoneyDao.reason(map);
    }

    /**
     * 公司审核驳回存历史审核记录
     * @param map
     * @return
     */
    @Override
    public int rejectMessage(Map map) {
        return wBorrowMoneyDao.rejectMessage(map);
    }

    @Override
    public int updateC(Map map) {
        return wBorrowMoneyDao.updateC(map);
    }

    @Override
    public int rejectMessageA(Map map) {
        return wBorrowMoneyDao.rejectMessageA(map);
    }

    @Override
    public int passMessage(Map map) {
        return wBorrowMoneyDao.passMessage(map);
    }

    @Override
    public int passMessageA(Map map) {
        return wBorrowMoneyDao.passMessageA(map);
    }


    @Override
    public List<Map> bsList() {
        return wBorrowMoneyDao.bsList();
    }

    @Override
    public List<BorrowMoney> getbePaging(Map map) {
        return wBorrowMoneyDao.getbePaging(map);
    }


    @Override
    public int getbePagingMap(Map map) {
        return wBorrowMoneyDao.getbePagingMap(map);
    }

    @Override
    public int updateA(Map map) {
        return wBorrowMoneyDao.updateA(map);
    }

    @Override
    public int reasonA(Map map) {
        return wBorrowMoneyDao.reasonA(map);
    }

    @Override
    public int updateB(Map map) {
        return wBorrowMoneyDao.updateB(map);
    }

    @Override
    public List<BorrowMoney> PagingA(Map map) {
        return wBorrowMoneyDao.PagingA(map);
    }

    @Override
    public int PagingMapA(Map map) {
        return wBorrowMoneyDao.PagingMapA(map);
    }

    @Override
    public List<BorrowMoney> rejectList() {
        return wBorrowMoneyDao.rejectList();
    }


    @Override
    public int rejectAMap(Map map) {
        return wBorrowMoneyDao.rejectAMap(map);
    }

    @Override
    public List<BorrowMoney> passMap() {
        return wBorrowMoneyDao.passMap();
    }

    @Override
    public List<BorrowMoney> passList(Map map) {
        return wBorrowMoneyDao.passList(map);
    }

    @Override
    public int passListA(Map map) {
        return wBorrowMoneyDao.passListA(map);
    }

    @Override
    public List<BorrowMoney> reList(Map map) {
        return wBorrowMoneyDao.reList(map);
    }

    @Override
    public int reListA(Map map) {
        return wBorrowMoneyDao.reListA(map);
    }


//    /**
//     * 驳回贷款 修改状态 存入驳回理由
//     * @param REASON
//     * @param LOANSSTATE
//     * @param LOANSID
//     * @return
//     */
//    @Override
//    public int reject(String REASON, Integer LOANSSTATE, Integer LOANSID) {
//        return loanAuditDao.reject(REASON,LOANSSTATE,LOANSID);
//    }
//
//    /**
//     * 通过理由
//     * @param LOANSID
//     * @return
//     */
//    @Override
//    public int passReason(Integer LOANSID) {
//        return loanAuditDao.passReason(LOANSID);
//    }
//
//    /**
//     * 驳回消息
//     * @param LOANSID
//     * @return
//     */
//    @Override
//    public int rejectReson(Integer LOANSID) {
//        return loanAuditDao.rejectReson(LOANSID);
//    }
//
//    /**
//     * 通过存历史审核记录
//     * @param LOANSID
//     * @return
//     */
//    @Override
//    public int passMessage(Integer LOANSID) {
//        return loanAuditDao.passMessage(LOANSID);
//    }
//
//    /**
//     * 驳回存历史审核记录
//     * @param LOANSID
//     * @return
//     */
//    @Override
//    public int rejectMessage(Integer LOANSID) {
//        return loanAuditDao.rejectMessage(LOANSID);
//    }
}
