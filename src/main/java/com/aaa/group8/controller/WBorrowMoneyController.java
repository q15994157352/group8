package com.aaa.group8.controller;

import com.aaa.group8.entity.BorrowMoney;
import com.aaa.group8.service.PsysMsgService;
import com.aaa.group8.service.WBorrowMoneyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ResourceLoader;

import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WBorrowMoneyController {
    @Autowired
    private WBorrowMoneyService wBorrowMoneyService;
   @Autowired
   private PsysMsgService psysMsgService;
    @Autowired
    private ResourceLoader resourceLoader;


    @RequestMapping("boList")
    public Object getboList(){
        return wBorrowMoneyService.boList();
    }

    @RequestMapping("bsList")
    public Object getbsList(){
        return wBorrowMoneyService.bsList();
    }

    @RequestMapping("pageA")
    public Object pageParam(@RequestBody Map map){
        List<BorrowMoney> borrowMonies = wBorrowMoneyService.getbePaging(map);
        int getbePagingMap = wBorrowMoneyService.getbePagingMap(map);
        Map mape=new HashMap();
        mape.put("borrowMonies",borrowMonies);
        mape.put("getbePagingMap",getbePagingMap);
        return mape;
    }
    @RequestMapping("pageD")
    public Object passpage(@RequestBody Map map){
        List<BorrowMoney> borrowMonies = wBorrowMoneyService.passList(map);
        int getbePagingMap = wBorrowMoneyService.passListA(map);
        Map mape=new HashMap();
        mape.put("borrowMonies",borrowMonies);
        mape.put("getbePagingMap",getbePagingMap);
        return mape;
    }
    @RequestMapping("pageE")
    public Object reListget(@RequestBody Map map){
        List<BorrowMoney> borrowMonies = wBorrowMoneyService.reList(map);
        int getbePagingMap = wBorrowMoneyService.reListA(map);
        Map mape=new HashMap();
        mape.put("borrowMonies",borrowMonies);
        mape.put("getbePagingMap",getbePagingMap);
        return mape;
    }

    @RequestMapping("pageB")
    public Object pageParamB(@RequestBody Map map){
        List<BorrowMoney> borrowMoniesA = wBorrowMoneyService.PagingA(map);
        int getbePagingMapA = wBorrowMoneyService.PagingMapA(map);
        Map mape=new HashMap();
        mape.put("PagingA",borrowMoniesA);
        mape.put("PagingMapA",getbePagingMapA);
        return mape;
    }
    @RequestMapping("pageC")
    public Object rejectA(@RequestBody Map map){
        List<BorrowMoney> borrowMonies = wBorrowMoneyService.rejectA(map);
        int aMap = wBorrowMoneyService.rejectAMap(map);
        Map mape=new HashMap();
        mape.put("borrowMonies",borrowMonies);
        mape.put("aMap",aMap);
        return mape;
    }
    @RequestMapping("page")
    public Object pageBoParam(@RequestBody Map map){
        List<BorrowMoney>pageList=wBorrowMoneyService.getboPaging(map);
        int pageMap =wBorrowMoneyService.getPagingMap(map);
        Map map1=new HashMap();
        map1.put("pageList",pageList);
        map1.put("pageMap",pageMap);
        return map1;
    }

    /**
     * 公司审核通过
     * 改变贷款表状态
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object update(@RequestParam Map map){
        System.out.println("update:"+map);
        int update = wBorrowMoneyService.update(map);
        int message = wBorrowMoneyService.passMessage(map);
        psysMsgService.addSystMeg(map);
        if (update ==1 & message == 1){
            wBorrowMoneyService.updateC(map);
        }
        return 1;
    }
    /**
     * 公司审核不通过
     * 添加到驳回记录表
     */
    @RequestMapping("reason")
    public Object reason(@RequestParam Map map){
        System.out.println(map);
        int reason = wBorrowMoneyService.reason(map);
        psysMsgService.addSystMeg(map);
        if (reason==1){
            wBorrowMoneyService.rejectMessageA(map);
        }

        return 1;
    }




    /**
     * 第一次借款审核通过
     */
    @RequestMapping("updateA")
    public Object updateA(@RequestParam Map map){
        System.out.println("updateA:"+map);
        psysMsgService.addSystMeg(map);
        return wBorrowMoneyService.updateA(map);
    }
    /**
     * 借款审核不通过
     */
    @RequestMapping("reasonA")
    public Object reasonA(@RequestParam Map map){
        System.out.println("reasonA"+map);
        int i = wBorrowMoneyService.reasonA(map);
        psysMsgService.addSystMeg(map);
        if (i ==1){
            wBorrowMoneyService.rejectMessage(map);
        }
        return 1;
    }
    /**
     * 第二次借款审核通过
     */
    @RequestMapping("updateB")
    public Object updateB(@RequestParam Map map){
        System.out.println(map);
        int i = wBorrowMoneyService.updateB(map);
        psysMsgService.addSystMeg(map);
        if (i == 1){
            wBorrowMoneyService.passMessageA(map);
        }
        return 1;
    }


    @RequestMapping("rejectList")
    public Object getreject(){
       return wBorrowMoneyService.rejectList();
    }


}
