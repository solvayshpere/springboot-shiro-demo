package com.solvay.shiro.realm;

import org.apache.shiro.util.SimpleByteSource;

import java.io.Serializable;

public class MyByteSourceBak extends SimpleByteSource implements Serializable {
    public MyByteSourceBak(String string) {
        super(string);
    }
}
