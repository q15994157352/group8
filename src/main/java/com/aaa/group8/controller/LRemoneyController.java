package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import com.aaa.group8.service.LloansinfoService;
import com.aaa.group8.service.LremoneyService;
import com.aaa.group8.service.PsysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("deal")
public class LRemoneyController {
        @Autowired
         private LloansinfoService lloansinfoService;
        @Autowired
        private LremoneyService lremoneyService;
        @Autowired
        private GAdminService gAdminService;
       @Autowired
       private PsysMsgService psysMsgService;
        @RequestMapping("list")
        public Object getRemoney(HttpSession session){
            GAdmin admin = (GAdmin)session.getAttribute("userSession");
            Integer ba_id=admin.getBa_id();
            List<Map> map = lremoneyService.getAll(ba_id);
            if (map.size()>0) {
                Integer bxi_instalment = Integer.parseInt(map.get(0).get("BXI_INSTALMENT").toString());
                for (int i = 0; i < bxi_instalment; i++) {
                    String TIME = map.get(i).get("BXI_TIME").toString();
                    System.out.println(TIME);
                    map.get(i).put("TIME", TIME);
                }
                System.out.println(map);
                return map;
            }else {
                System.out.println("当前没有可还款业务");
                return 0;
            }
        }

        @RequestMapping("save")
        @ResponseBody
         public Object finCompanyMoney(@RequestBody Map map,HttpSession session){
            System.out.println(map);
//            获取当前系统时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            System.out.println(format);
            String BFI_DATE=format;
            map.put("BFI_DATE",BFI_DATE);

            String time = map.get("TIME").toString();
            System.out.println(time);

            System.out.println(format.equals(time));

            if (format.equals(time)){
                GAdmin admin = (GAdmin)session.getAttribute("userSession");
                Integer ba_id=admin.getBa_id();
                map.put("ba_id",ba_id);
                List<GAdmin> userList = gAdminService.getListAll(map);
                map.put("bs_message","恭喜您本月还款成功");
                map.put("bs_status","还款成功");
                psysMsgService.addSystMeg(map);
                Integer bci_id =Integer.parseInt(map.get("BCI_ID").toString()) ;
                double bxi_money = Double.parseDouble(map.get("BXI_MONEY").toString());
                Map money = lremoneyService.findMoney(bci_id);
                double bci_money = Double.parseDouble(money.get("BCI_MONEY").toString());
                List<Map> maps = lremoneyService.getStatus(map);
                Integer bxi_status = Integer.parseInt(maps.get(0).get("BXI_STATUS").toString());
                if (bxi_status==0) {
                    if (bci_money > bxi_money) {
                        int i = lremoneyService.updateCompanyMoney(map);
                        int i1 = lremoneyService.updateBAnkcard(map);
                        int i2 = lremoneyService.updateStatus(map);
                        System.out.println(33);
                        int i3 = lremoneyService.addRemoney(map);

                        Double  money1= lloansinfoService.getMoney();
                        map.put("blb_money",money1);
                        int i4 = lremoneyService.addHu(map);
                        return i + i1 + i2 + i3 + i4;
                    } else {
                        return 0;
                    }

                }else {
                    return 2;
                }
            }else {
                return 1;
            }
        }
    @RequestMapping("getRemoneyList")
    public Object hetRemoneyList(HttpSession session){
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
        Integer ba_id=admin.getBa_id();
        List<Map> remoneyList = lremoneyService.getRemoneyList(ba_id);
        if (remoneyList.size()>0){
            return remoneyList;
        }
        return "暂无还款记录";
    }
    @RequestMapping("getThem")
    public Object getAllMing(){
        List<Map> map = lremoneyService.getAllMing();
        for (int i = 0; i < map.size(); i++) {
            String TIME = map.get(i).get("BFI_DATE").toString();
            System.out.println(TIME);
            map.get(i).put("TIME", TIME);
        }
        System.out.println(map);
        return map;
    }
}
