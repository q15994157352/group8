package com.aaa.group8.shiro;


import com.aaa.group8.entity.GAdmin;
import com.aaa.group8.service.GAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录认证与权限
 */
public class MyShiroRealm extends AuthorizingRealm implements Serializable{

    @Autowired
    private GAdminService gAdminService;



    /**
     *授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证
     * @param
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm启动");
        //获取username
        String userName = (String)token.getPrincipal();
        Session session = SecurityUtils.getSubject().getSession();
        Map map  = new HashMap<>();
        map.put("ba_zhanghao",userName);
        //通过username查询
        List<GAdmin> listAll = gAdminService.getListAll(map);
        GAdmin customer =null;
        if(listAll!=null&&listAll.size()>0){
            customer=listAll.get(0);
        }
        if(customer==null) {
            throw  new UnknownAccountException();
        }
		/*if (0==emp.getEnable()) {
			throw new LockedAccountException(); // 帐号锁定
		}*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                customer,//用户名
                customer.getBa_password(),//密码
                "MyRealm"//realm name
        );
        //设置盐
        //authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        //当验证信息都通过后，把用户信息放在session里
        session.setAttribute("userSession",customer);
        return authenticationInfo;
    }
}
