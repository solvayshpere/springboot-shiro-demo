package com.solvay.shiro.realm;

import com.solvay.shiro.entity.TPerms;
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
import org.apache.shiro.util.ByteSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class CustomerRealmMd5 extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();
        System.out.println("primaryPrincipal = " + primaryPrincipal);

        //根据主身份信息获取角色 和 权限信息
        TUserService userService = (TUserService) ApplicationContextUtils.getBean("tUserService");
        TUser user = userService.findRolesByUsername(primaryPrincipal);
        //授权角色信息
        if(!CollectionUtils.isEmpty(user.getRoles())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                //权限信息
                List<TPerms> perms = userService.findPermsByRoleId(role.getId());
                if(!CollectionUtils.isEmpty(perms)){
                    perms.forEach(perm->{
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户名key
        String principal = (String) token.getPrincipal();
        //在工厂中获取service对象
        TUserService userService = (TUserService) ApplicationContextUtils.getBean("tUserService");
        //根据身份信息查询
        TUser user = userService.findByUsername(principal);
        if(!ObjectUtils.isEmpty(user)){
            //返回数据库信息
            return new SimpleAuthenticationInfo(
                    user.getUsername(),
                    user.getPassword(),
                    //ByteSource.Util.bytes(user.getSalt()),
                    new MyByteSourceBak(user.getSalt()),
                    this.getName());
        }
        return null;
    }
}
