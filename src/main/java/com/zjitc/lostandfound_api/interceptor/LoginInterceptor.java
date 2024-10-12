package com.agileboot.api.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.agileboot.api.utils.JwtToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        JwtToken jwtToken = new JwtToken();
        String token = request.getHeader("Authorization");
        try{
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            String redisToken = ops.get(token);
            if(redisToken == null){
                throw new RuntimeException();
            }
            Map<String, Claim> claims = jwtToken.verify(token);
            return true;
        }catch (Exception e){
            System.out.println("触发了401");
            response.setStatus(401);
            return false;
        }

    }
}
