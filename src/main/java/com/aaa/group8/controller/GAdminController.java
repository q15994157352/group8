package com.aaa.group8.controller;

import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * 前台登录注册
 * 高运来
 */
@RestController
@RequestMapping("admin")
public class GAdminController{

    @Autowired
    private GAdminService gAdminService;

    /**
     * 查询用户表所有数据
     * @param map
     * @return
     */
 /*   @RequestMapping("list")
    public Object listAll(@RequestParam Map map){
        return gAdminService.getListAll(map);
    }*/

    /**
     * 登录
     * @param map
     * @param session
     * @return
     */
    @RequestMapping("/tologin")
    public String getListAll(@RequestParam Map map, HttpSession session){
//        获取前台传来的数据
        String userName = map.get("username") + "";
        String password = map.get("password") + "";
        String phone = map.get("phone") + "";
        String tologin = map.get("login") + "";

//        调用subject对象
        Subject subject = SecurityUtils.getSubject();

        String msg="";

        Map isphone = new HashMap<>();
        isphone.put("phone",phone);
        isphone.put("username",userName);

        GAdmin userBytel = gAdminService.getUserBytel(isphone);
        if (userBytel!=null && userBytel.toString()!=""){
            //获取本地验证码
            String login =(String) session.getAttribute("login");
//            如果已输入验证码
            if (tologin!=null){
                //            验证码效验
                if (login.equals(tologin)){
//            通过用户的登陆信息创建token
//            将用户的数据保存到token中，并经由MyShiroRealm进行校验
                    UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

                    try {
//                触发MyShiroRealm
                        subject.login(token);
                        return msg="suc";
                    } catch (AuthenticationException exception) {
                        //清除session
                        token.clear();
                        //自定义信息
                        if (UnknownAccountException.class.getName().equals(exception+"")) {
                            msg = "您输入的账号不存在~";
                        } else if (IncorrectCredentialsException.class.getName().equals(exception.getClass().getName())) {
                            msg = "您输入的密码不正确~";
                        } else if (LockedAccountException.class.getName().equals(exception.getClass().getName()) ){
                            msg = " 您的账号已经被锁定 无法登入系统~";
                        } else {
                            msg = "账号或者密码错误~";
                        }
                        // 此方法不处理登录成功,由shiro进行处理
                    }
                }else {
                    return msg="验证码错误，请重新输入";
                }
            }else {
                return msg="未输入验证码";
            }

        }else {
            return msg="非注册手机号，请输入正确手机号";
        }

        return msg;
    }

    /**
     * 获取用户名
     * @param
     * @return
     */
    @RequestMapping("sendUserName")
    public Object turnIndexPage() {
//        取出session中的数据
        Session session = SecurityUtils.getSubject().getSession();
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
        if (admin==null){
            return null;
        }

        Map map = new HashMap<>();
        map.put("userName",admin.getBa_zhanghao());
//        将获取到的用户数据发送到前台
//        modelMap.addAttribute("admin", admin);
//        return "/front/head.html";
        return map;
    }

    /**
     * 注册
     * @param map
     * @return
     */
    @RequestMapping("/create")
    public Object create(@RequestParam Map map,HttpSession session){
//        获取前台传来的数据
        String username = map.get("username") + "";
        String password = map.get("password") + "";
        String passwordcheck = map.get("repeatPassword") + "";
        String tel = map.get("tel") + "";
        String rean = map.get("readom") + "";
//获取本地验证码
        String reandom =(String) session.getAttribute("reandom");

//        System.out.println(username+"  "+password+"  "+passwordcheck+"  "+tel+"  "+rean);

        Map<Object, Object> hashMap = new HashMap<>();

//        判断用户名是否已存在
        int userByname = gAdminService.getUserByname(username);
//            已被注册,不可用，返回400
        if (userByname>0){
            hashMap.put("code","400");
        }else {
//              密码不一致，返回500
            if (password.equals(passwordcheck)){
//                密码一致，验证手机验证码
                if (rean.equals(reandom)){
//                    手机号是否为11位
                    if (tel.length()==11){
                        int i = gAdminService.create(map);
//                   保存成功返回200
                        if (i>0){
                            hashMap.put("code","200");
                        }
                    }else {
//                        手机号不为11位,返回100
                        hashMap.put("code","100");

                    }

                }else {
//                   验证码错误，返回300
                    hashMap.put("code","300");
                }
            }else {
//             密码不一致，返回500
                hashMap.put("code","500");
            }
        }
//        清除验证码的session
        session.removeAttribute("reandom");
        return hashMap;
    }

    /**
     * 用户名唯一性效验
     * @param username
     * @return
     */
    @RequestMapping("/isname")
    public Object getByName(@RequestParam String username,HttpServletResponse response) throws IOException {

        response.setContentType("text/json;charset=UTF-8");
        int userByname = gAdminService.getUserByname(username);
        Map<Object, Object> map = new HashMap<>();

        if (userByname>0){
//            已被注册,不可用
            map.put("code","400");
        }else {
//            可用
            map.put("code","200");
        }
        return map;
    }

    /**
     * 用户退出
     * @return
     */
    @RequestMapping("logout")
    public Object logout(){
        //        取出session中的数据
        Session session = SecurityUtils.getSubject().getSession();
        GAdmin admin = (GAdmin)session.getAttribute("userSession");
        Map<Object, Object> map = new HashMap<>();
        if (admin==null && admin.equals("")){
           map.put("code","400");
        }else {
            session.removeAttribute("userSession");
            map.put("code","200");
        }
        return map;
    }
}
