package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.LEmitService;
import com.aaa.group8.service.LloansinfoService;
import com.aaa.group8.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("loan")
public class LLoansinfoController {
    @Autowired
    private LloansinfoService lloansinfoService;
    @Autowired
    private LEmitService lEmitService;

    /**
     * 查询已审核信息
     * @return
     */
    @RequestMapping("list")
    public Object getAll(){
        List<Map> allReview = lloansinfoService.getAllReview();
//        System.out.println(1111);
//        System.out.println(allReview);
        return allReview;
    }
    /**
     * 查询已放款信息
     */
    @RequestMapping("getAll")
    public Object getListAll(){
        List<Map> listAll = lloansinfoService.getListAll();
//        System.out.println(2222);
//        System.out.println(listAll);
        return listAll;
    }

    /**
     * 放款并扣除本公司银行卡金额
     * 完成贷款放款
     * @param map
     * @return
     */
    @RequestMapping("update")
    public Object updateBank(@RequestBody Map map){
//        System.out.println(333);
//        System.out.println(map);
//        System.out.println(map.get("bci_id"));
//
//

        Integer bli_instalment =(Integer) map.get("bli_instalment");
        double instalment = Double.parseDouble(map.get("bli_instalment").toString());
//        System.out.println(bli_instalment);
        double money = Double.parseDouble(map.get("bli_money").toString());
        Double bli_money=(Double)(money+(money*0.30))/instalment;


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(new Date());
        String BRI_LOANSDATE = format;

        Integer bci_id=Integer.parseInt(map.get("bci_id").toString());
        int BA_ID = lloansinfoService.getId(bci_id);
        map.put("BA_ID",BA_ID);
        map.put("BFI_DATE",BRI_LOANSDATE);


        for (int bxi_month=1;bxi_month<=bli_instalment;bxi_month++){
            try {
                map.put("bxi_month",bxi_month);
                map.put("bxi_money",bli_money);
                format = DateUtil.getDate(format);
                map.put("bxi_time",format);
//                System.out.println(format);
                int i2 = lEmitService.addEmit(map);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        int a = lloansinfoService.updateBank(map);
        int i = lloansinfoService.updateStatus(map);
        int i1 = lloansinfoService.updateMoney(map);

        Double  bci_money= lloansinfoService.getMoney();
        map.put("bci_money",bci_money);
        int i3 = lloansinfoService.addZhang(map);
//        System.out.println(i1);
//        System.out.println(i);
//        System.out.println(a);
        return a+i+i1+i3;
    }
}
