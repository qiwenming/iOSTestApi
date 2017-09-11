package com.qwm.iostestapi;

import com.qwm.iostestapi.utils.Md5Utils;

public class Test {
    public static void main(String[] args){
        System.out.println(Md5Utils.md5Encode(   Md5Utils.md5Encode("123456")  ));
    }
}
