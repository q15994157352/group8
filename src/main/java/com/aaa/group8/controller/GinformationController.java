package com.aaa.group8.controller;

import com.aaa.group8.dao.GInformationDAO;
import com.aaa.group8.entity.GAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 查出用户账单数据
 */
@RestController
@RequestMapping("informoney")
public class GinformationController {

    @Autowired
    private GInformationDAO gInformationDAO;

    /**
     * 用户所有信息
     * @param session
     * @return
     */
/*    @RequestMapping("getinfo")
    public Object getinfo(HttpSession session){
//        获取用户id
        GAdmin userSession =(GAdmin) session.getAttribute("userSession");
        Integer ba_id = userSession.getBa_id();

        //        查询个人信息
        Map listMation = gInformationDAO.listMation(ba_id);
//        用户id
        Object bid = listMation.get("BA_ID");
//        账户余额
        Object bcimoney = listMation.get("BCI_MONEY");
//        借款金额
        Object blimoney = listMation.get("BLI_MONEY");
//           用户名
        Object bazhanghao = listMation.get("BA_ZHANGHAO");
//        用户期数
        String stalment = listMation.get("BXI_INSTALMENT").toString();
        int i = Integer.parseInt(stalment);

//        已还金额
        Map listmoney = gInformationDAO.listmoney(ba_id);
        Object money = listmoney.get("MONEY");

        //        未还金额
        Map notmoney = gInformationDAO.notmoney(ba_id);
        Object nomoney = notmoney.get("NOTMONEY");
        System.out.println(notmoney);
        System.out.println(nomoney);

        Map hashMap = new HashMap<>();

        hashMap.put("bid",bid);
        hashMap.put("bcimoney",bcimoney);
        hashMap.put("blimoney",blimoney);
        hashMap.put("money",money);
        hashMap.put("bazhanghao",bazhanghao);
        hashMap.put("nomoney",nomoney);

        return hashMap;
    }*/

    /**
     * 用户账户信息
     * @param session
     * @return
     */
    @RequestMapping("getlist")
    public Object getListInfo(HttpSession session){

        GAdmin userSession =(GAdmin) session.getAttribute("userSession");
        Integer ba_id = userSession.getBa_id();
//        try {
            Map hashMap = new HashMap<>();
            //        查询个人信息
            Map listMation = gInformationDAO.listMation(ba_id);
            if (listMation!=null){
                //        用户id
                Object bid = listMation.get("BA_ID");
//        账户余额
                 Object bcimoney = listMation.get("BCI_MONEY");
//        借款金额
                Object blimoney = listMation.get("BLI_MONEY");
//           用户名
                Object bazhanghao = listMation.get("BA_ZHANGHAO");
//        用户期数
                String stalment = listMation.get("BXI_INSTALMENT").toString();
                int i = Integer.parseInt(stalment);

                //        已还金额
                Map listmoney = gInformationDAO.listmoney(ba_id);

                Object money = listmoney.get("MONEY");
                hashMap.put("money",money);

                hashMap.put("bid",bid);
                hashMap.put("bcimoney",bcimoney);
                hashMap.put("blimoney",blimoney);
                hashMap.put("bazhanghao",bazhanghao);

                //        查询用户的状态码
                int isstatus = gInformationDAO.isstatus(ba_id);
//        如果与期数不相等，说明未还完，继续还

                if (isstatus!=i){
//        未还金额
                    Map notmoney = gInformationDAO.notmoney(ba_id);
                    Object nomoney = notmoney.get("NOTMONEY");

                    hashMap.put("nomoney",nomoney);

                }else {
//        如果与期数相等，说明已还完，返回0
                    hashMap.put("nomoney",0);
                }

            }

            return hashMap;
    }

    /**
     * 查询已借金额,账户余额
     * @param session
     * @return
     */
    @RequestMapping("loadmoney")
    public Object loadmoney(HttpSession session){
        GAdmin userSession =(GAdmin) session.getAttribute("userSession");
        Integer ba_id = userSession.getBa_id();
        Map map = gInformationDAO.loanmoney(ba_id);
        return map;
    }
}
