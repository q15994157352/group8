package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import com.aaa.group8.util.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 手机验证码
 * 高运来
 */
@RestController
@RequestMapping("send")
public class GSendMessageController {

    @Autowired
    private GAdminService gAdminService;


    //        sms用户id
    String uid="18638266692sms";
    //        接口秘钥
    String key="d41d8cd98f00b204e980";

    /**
     * 注册时手机验证码
     * @param map
     * @return
     */
    @RequestMapping("/message")
    public Object sendMessage(@RequestParam Map map, HttpSession session){
        Map<String, String> hashMap = new HashMap<>();

//        目标手机号
        String phone = map.get("phone").toString();

//        生成验证码
        String randomCode = SendMessageUtil.getRandomCode(6);

        Integer send=null;

//手机号不为空，发送验证码
        if (phone!=null && phone!="" && phone.length()==11){
//            System.out.println("手机验证码信息"+"sms账号:"+uid+"。。秘钥:"+key+"。。短信内容："+randomCode+"。。目标手机号："+phone);

//        发送验证码,此为真实数据，次数有限，慎用！！！
        send = SendMessageUtil.send(uid, key, phone, randomCode);

            send = 1;

//        大于0，表示成功，小于0，提示错误
            if (send > 0){
                System.out.println("验证码发送成功:"+randomCode);
                hashMap.put("code","200");
//            向前台发送验证码
                hashMap.put("reandom",randomCode);
//            向session放验证码，以便于判断
                session.setAttribute("reandom",randomCode);
            }else {
                String message = SendMessageUtil.getMessage(send);

                hashMap.put("message",message);
                hashMap.put("code","400");
            }
        }else {
//        如果手机号输入为空或不够11位，返回500
            hashMap.put("code","500");
        }
        return hashMap;
    }

    /**
     * 登录时手机验证码
     * @param map
     * @return
     */
    @RequestMapping("/adminmessage")
    public Object adminMessage(@RequestParam Map map, HttpSession session){
        Map<String, String> hashMap = new HashMap<>();

//        目标手机号
        String phone = map.get("phone").toString();

        String username = map.get("username").toString();

        Map isphone = new HashMap<>();
        isphone.put("phone",phone);
        isphone.put("username",username);

//        生成验证码
        String randomCode = SendMessageUtil.getRandomCode(6);

        Integer send=null;

//手机号不为空，发送验证码
        if (phone!=null && phone!="" && phone.length()==11){

//            验证输入的手机号
            GAdmin userBytel = gAdminService.getUserBytel(isphone);
            if (userBytel!=null && userBytel.toString()!=""){
//            System.out.println("手机验证码信息"+"sms账号:"+uid+"。。秘钥:"+key+"。。短信内容："+randomCode+"。。目标手机号："+phone);

//        发送验证码,此为真实数据，次数有限，慎用！！！
//        send = SendMessageUtil.send(uid, key, phone, randomCode);
                send = 1;

//        大于0，表示成功，小于0，提示错误
                if (send > 0){
                    System.out.println("验证码发送成功:"+randomCode);
                    hashMap.put("code","200");
//            向前台发送验证码
                    hashMap.put("reandom",randomCode);
//            向session放验证码，以便于判断
                    session.setAttribute("login",randomCode);
                }else {
                    String message = SendMessageUtil.getMessage(send);

                    hashMap.put("message",message);
                    hashMap.put("code","400");
                }
            }else {
//                手机号为非注册手机号,100
                hashMap.put("code","100");

            }

        }else {
//        如果手机号输入为空或不够11位，返回500
            hashMap.put("code","500");
        }
        return hashMap;
    }
}
