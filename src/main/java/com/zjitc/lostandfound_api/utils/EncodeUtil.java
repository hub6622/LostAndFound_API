package com.zjitc.lostandfound_api.utils;


import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {

    public String Md5Encode(String Pwd){
        String encodePwd = "";
        try{
            encodePwd = DigestUtils.md5DigestAsHex(Pwd.getBytes("utf-8"));

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return encodePwd;
    }
    public Boolean checkPassword(String encodePwd, String pwd){
        return Md5Encode(pwd).equals(encodePwd);
    }
}

