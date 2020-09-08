package com.solvay.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class TestAuthenticator {

    public static void main(String[] args) {
        //创建securityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //将安装工具类中设置默认安全管理器
        SecurityUtils.setSecurityManager(securityManager);

        //3. 获取主体对象
        Subject subject = SecurityUtils.getSubject();

        //4. 创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen", "123");

        //5.执行登录方法
        try{
            subject.login(token);
            System.out.println("登录成功~~");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户名错误!!");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误!!!");
        }

    }
}
