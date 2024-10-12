package com.agileboot.api.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeUtil {
    BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * 使用 BCrypt 对密码进行加密
     * @param pwd 明文密码
     * @return 加密后的密码
     */
    public String bcryptEncode(String pwd) {

        String encodedPwd = bcryptPasswordEncoder.encode(pwd);
        return encodedPwd;
    }

    /**
     * 验证密码是否匹配
     * @param plainPwd 明文密码
     * @param encodedPwd 加密后的密码
     * @return 是否匹配
     */
    public boolean checkPassword(String plainPwd, String encodedPwd) {
        return bcryptPasswordEncoder.matches(plainPwd, encodedPwd);
    }
}
