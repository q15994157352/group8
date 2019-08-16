package com.aaa.group8.shiro;


import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro拦截
 */

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

//        注入setSecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        // 配置不会被拦截的链接 顺序判断
        //放开static resources

//        放开样式和js
        filterChainDefinitionMap.put("/bootstrap/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/iconfont/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/script/**", "anon");
        filterChainDefinitionMap.put("/image/**", "anon");

//      放开前台登录,注册,主界面,头部，尾部,关于我们，安全保障
        filterChainDefinitionMap.put("/front/login.html", "anon");
        filterChainDefinitionMap.put("/front/create.html", "anon");
        filterChainDefinitionMap.put("/front/index.html", "anon");
        filterChainDefinitionMap.put("/front/head.html", "anon");
        filterChainDefinitionMap.put("/front/last.html", "anon");
        filterChainDefinitionMap.put("/front/help.html", "anon");
        filterChainDefinitionMap.put("/front/about.html", "anon");

//        放开后台登录界面,主页面



        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->

//        开启拦截，所有的访问必须通过登录
        filterChainDefinitionMap.put("/front/**.html", "authc");
//        filterChainDefinitionMap.put("/views/**", "authc");
//        filterChainDefinitionMap.put("/BackStageUser/**", "authc");
//        filterChainDefinitionMap.put("/LRequest/**", "authc");

//        拦截后要跳转的页面
        // 如果不设置默认会自动寻找Web工程根目录下的"/login"页面
        shiroFilterFactoryBean.setLoginUrl("/front/login.html");


        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/views/index.html");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;
    }


    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
}
