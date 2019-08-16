package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.MBillService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 账单controller
 */
@RestController
@RequestMapping("mbill")
public class MBillController {

    @Autowired
    private MBillService mBillService;

    @RequestMapping("list")
    public Object getAllLiset(){

        Session session = SecurityUtils.getSubject().getSession();
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
        Integer ba_id2 = admin.getBa_id();
        List<Map> allList = mBillService.getAllList(ba_id2);
        System.out.println(allList);

        return  allList;
    }


}
