package com.zjitc.lostandfound_api;

import com.zjitc.lostandfound_api.mapper.AdminMapper;
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.service.AdminService;
import com.zjitc.lostandfound_api.utils.EncodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LostAndFoundApiApplicationTests {
    @Resource
    UserMapper userMapper;
    @Resource
    AdminService adminService;

    @Test
    void contextLoads() {
        EncodeUtil encodeUtil = new EncodeUtil();
        System.out.println(encodeUtil.Md5Encode("admin123"));
    }
    @Test
    void test(){
        System.out.println(adminService.getAllComment());
    }
}
