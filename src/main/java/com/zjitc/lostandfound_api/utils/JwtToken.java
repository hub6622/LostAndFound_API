package com.zjitc.lostandfound_api.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zjitc.lostandfound_api.pojo.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JwtToken {
    public String encode(User user){
        HashMap<String, Object> map=new HashMap<>();
//        创建时间instance
        Calendar instance = Calendar.getInstance();
//        设置时间 默认秒
        instance.add(Calendar.HOUR,2);
//        创建token添加头，有效载荷，和签名
        String token = JWT.create()
                .withHeader(map)
                .withClaim("id", user.getId())
                .withClaim("username",user.getName())
//                获取instance时间，设置有效时间
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("PPG"));// 密钥
        return token;
    }
    public Map<String, Claim> verify(String token){
        try{
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("PPG")).build();
            DecodedJWT Decoded = jwtVerifier.verify(token);
            Map<String, Claim> claimMap = Decoded.getClaims();
//            System.out.println(verify.getClaim("id"));
//            System.out.println(verify.getClaim("username"));
//            System.out.println("令牌过期时间：" + verify.getExpiresAt());
            return claimMap;
        }catch (SignatureVerificationException e){
            e.printStackTrace();
        }
        return null;
    }
}
