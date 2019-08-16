package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import com.aaa.group8.service.LRechargeService;
import com.aaa.group8.service.PsysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("remo")
public class LRechargeController {
    @Autowired
    private LRechargeService lRechargeService;
    @Autowired
    private GAdminService gAdminService;
    @Autowired
    private PsysMsgService psysMsgService;
    /**
     * 获取前台还款信息
     * @return
     */
    @RequestMapping("list")
    public Object getInfo(HttpSession session){
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
//        System.out.println(admin.getBa_id());
        Integer ba_id=admin.getBa_id();
        List<Map> map = lRechargeService.getInfo(ba_id);
//        System.out.println(map);
        return map;
    }

    /**
     * 客户账户充值
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("toUpdate")
    public Object ToUpdate(@RequestBody Map map,HttpSession session){
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
//        System.out.println(admin.getBa_id());
        Integer ba_id=admin.getBa_id();
        map.put("ba_id",ba_id);
        List<GAdmin> userList = gAdminService.getListAll(map);
        map.put("bs_message","恭喜您充值"+map.get("ba_money")+"元成功");
        map.put("bs_status","充值成功");
        psysMsgService.addSystMeg(map);
        List<Map> map1 = lRechargeService.getInfo(ba_id);
        Object deal =  map.get("deal");
        Object bci_deal = map1.get(0).get("BCI_DEAL");
//        System.out.println(deal);
//        System.out.println(bci_deal);
//        System.out.println(map);
//        System.out.println(deal.getClass().getName());
//        System.out.println(bci_deal.getClass().getName());
        Double ba_money=Double.parseDouble(map.get("ba_money").toString());
        boolean i=deal.equals(bci_deal);
//        System.out.println(i);
        if (deal.equals(bci_deal)){
            if(ba_money<=80000.00){
                return lRechargeService.toUpdate(map);
            }
           return 2;
        }else {
            return 0;
        }
    }

    @RequestMapping("forUpdate")
    public Object ForUpdate(@RequestBody Map map,HttpSession session){
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
//        System.out.println(admin.getBa_id());
        Integer ba_id=admin.getBa_id();
        map.put("ba_id",ba_id);
        List<GAdmin> userList = gAdminService.getListAll(map);
        map.put("bs_message","恭喜您提现"+map.get("bci_money")+"元成功");
        map.put("bs_status","提现成功");
        psysMsgService.addSystMeg(map);
        List<Map> map1 = lRechargeService.getInfo(ba_id);
        Object deal =  map.get("deal");
        Object bci_deal = map1.get(0).get("BCI_DEAL");
        double bci_money = Double.parseDouble(map.get("bci_money").toString());

//        System.out.println(deal);
//        System.out.println(bci_deal);
//        System.out.println(map);

        int bci_id = Integer.parseInt(map.get("bci_id").toString());
        List<Map> maps = lRechargeService.findUserMoney(bci_id);
//        System.out.println(maps);
        double money = Double.parseDouble(maps.get(0).get("BCI_MONEY").toString());

//        System.out.println(ba_money);

        boolean i=deal.equals(bci_deal);
//        System.out.println(i);
        if (deal.equals(bci_deal)){
            if (money>=bci_money){
                int i1 = lRechargeService.infoUpdate(map);
                int i2 = lRechargeService.forUpdate(map);
                return i1+i2;
            }
            return 1;
        }else {
            return 0;
        }
    }
    /**
     * 客户还款
     * @param map
     * @return
     */
    @RequestMapping("onUpdate")
    public Object OnUpdate(@RequestBody Map map,HttpSession session){
//        System.out.println(map);
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
//        System.out.println(admin.getBa_id());
        Integer ba_id=admin.getBa_id();
        List<Map> map1 = lRechargeService.getInfo(ba_id);
        Object bci_deal = map1.get(0).get("BCI_DEAL");
        Object deal =  map.get("bci_deal");
        boolean a=deal.equals(bci_deal);
//        System.out.println(a);
        if (deal.equals(bci_deal)){
            int update = lRechargeService.getUpdate(map);
            int i = lRechargeService.myUpdate(map);
            int i1 = lRechargeService.myAdd(map);
            return update+i+i1;
        }else {
            return 0;
        }


    }
}
