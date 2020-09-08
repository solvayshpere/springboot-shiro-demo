package com.solvay.shiro.util;

import java.util.Random;

public class SaltUtils {
    public static String getSalt(int n){
        StringBuilder sb = new StringBuilder();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "abcdefghijklmnopqrstuvwxyz!@#$%^&*()";
        char[] code = chars.toCharArray();
        for (int i = 0; i < n; i++) {
            sb.append(code[new Random().nextInt(code.length)]);
        }
        return sb.toString();
    }
}
