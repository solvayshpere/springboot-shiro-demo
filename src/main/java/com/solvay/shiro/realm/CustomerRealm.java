package com.solvay.shiro.realm;

import com.solvay.shiro.entity.TUser;
import com.solvay.shiro.service.TUserService;
import com.solvay.shiro.util.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;

public class CustomerRealm extends AuthorizingRealm {

    /**
     * 授权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("primaryPrincipal = " + primaryPrincipal);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addRole("admin"); //添加角色admin

        simpleAuthorizationInfo.addStringPermission("user:update:*");
        simpleAuthorizationInfo.addStringPermission("product:*:01");//权限字符串 product 可以对01实例执行任何操作
        return simpleAuthorizationInfo;
    }

    /**
     * 身份认证方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名key
        String principal = (String) token.getPrincipal();
        //TODO 根据前台传递过来的principal身份信息去使用jdbc或者mybatis查询数据库
        if("xiaochen".equals(principal)){
            /**
             * principal：返回当前数据库中的正确用户名
             * credentials:返回当前数据库中正确的密码
             * realmName:当前realm名字
             */
            return new SimpleAuthenticationInfo(principal,"123",this.getName());
        }
        return null;
    }
}
