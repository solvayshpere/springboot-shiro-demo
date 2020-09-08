package com.solvay.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 测试hash,salt,散列
 */
public class TestHash {
    public static void main(String[] args) {
        //1.不加salt和散列次数
        Md5Hash md5Hash1 = new Md5Hash("123");
        System.out.println(md5Hash1.toHex()); //转成16进制字符串
        //2.加salt,不添加散列次数
        Md5Hash md5Hash2 = new Md5Hash("123","Xq*07");
        System.out.println(md5Hash2.toHex());
        //3.加salt,添加散列次数1024次
        Md5Hash md5Hash3 = new Md5Hash("123","Xq*07",1024);
        System.out.println(md5Hash3.toHex());
    }
}
