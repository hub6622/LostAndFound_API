package com.zjitc.lostandfound_api.config;

import com.zjitc.lostandfound_api.interceptor.LoginInterceptor;
import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .excludePathPatterns(
//                        "/user/login/**",
//                        "/user/register",
//                        "/item/list",
//                        "/item/getItemById/**",
//                        "/item/getItemByCategory/**",
//                        "/item/commentsByItemId/**",
//                        "/item/getCategory",
//                        "/item/hotItem",
//                        "/item/updateItemViewCounts/**"
//                );
    }
}
