package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户账户修改
 * 高运来
 */
@RestController
@RequestMapping("modify")
public class GModifyController {

    @Autowired
    private GModifyService modifyService;

//    查询用户所有数据
    @RequestMapping("/userAll")
    public Object getListAll(HttpSession session){
//        通过session获取用户id
        GAdmin userSession =(GAdmin) session.getAttribute("userSession");
        Integer ba_id = userSession.getBa_id();

        Map map = modifyService.listAllUser(ba_id);

        return map;
    }

//    修改用户信息
    @RequestMapping("update")
    public Object updaet(@RequestParam Map map){
        String baid = map.get("baid").toString() ;
        String zhanghao = map.get("zhanghao").toString() ;
        String password = map.get("password").toString();
        String tel = map.get("tel").toString();
        String bcdeal = map.get("bcdeal").toString() ;
        String bcemail = map.get("bcemail").toString();
        String bcbankcard = map.get("bcbankcard").toString();
//将id转换为int类型
        int id = Integer.parseInt(baid);
        int deal = Integer.parseInt(bcdeal);


//        System.out.println(id+zhanghao+password+tel+deal+bcemail+bcbankcard);

//        修改用户信息
        Map<String, Object> users = new HashMap<>();
        users.put("BA_ID",id);
        users.put("BA_ZHANGHAO",zhanghao);
        users.put("BA_PASSWORD",password);
        users.put("BA_TEL",tel);
        users.put("BCI_DEAL",deal);
        users.put("BCI_EMAIL",bcemail);
        users.put("BCI_BANKCARD",bcbankcard);

        int admin = modifyService.updateuser(users);
        int company = modifyService.updatecompany(users);
       if (admin>0 && company>0){
           return "成功";
       }
        return "";
    }

}
