package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.PsysMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("syst")
public class PsysMsgController {
    @Autowired
    private PsysMsgService psysMsgService;
    /**
     * 测试
     * bs_message 数据类型String  向客户发送的信息内容
     * bu_id 数据类型 int   客户id
     * bs_status  数据类型 String 客户状态
     *
     * @param map
     */
    @RequestMapping("getMessage")
    public Object getMessage(@RequestBody Map map, HttpServletRequest request) {
        HttpSession session = request.getSession();
        GAdmin user = (GAdmin) session.getAttribute("userSession");
        int ba_id = Integer.parseInt(user.getBa_id().toString());
        map.put("ba_id", user.getBa_id());
        Map Message = new HashMap();
        Message.put("total", psysMsgService.getTotal(map));
        Message.put("AllMessage", psysMsgService.getAllMessage(map));
        System.out.println(psysMsgService.getAllMessage(map));
        Message.put("uAllMessage", psysMsgService.getUAllMessage(ba_id));
        return Message;
    }

    @RequestMapping("delMessage/{bs_id}")
    public Object delMessage(@PathVariable int bs_id) {
        int i = psysMsgService.delMessage(bs_id);
        Map delMap = new HashMap();
        if (i > 0) {
            delMap.put("msg", "success");
        } else {
            delMap.put("msg", "fail");
        }
        return delMap;
    }

    @RequestMapping("updateMessage")
    public Object updateMessage(HttpServletRequest request) {
        HttpSession session = request.getSession();
        GAdmin user = (GAdmin) session.getAttribute("userSession");
        int ba_id = Integer.parseInt(user.getBa_id().toString());
        return psysMsgService.updateMessage(ba_id);
    }
}
