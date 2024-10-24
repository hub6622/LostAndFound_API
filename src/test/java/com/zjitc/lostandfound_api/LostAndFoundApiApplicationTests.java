package com.zjitc.lostandfound_api;

import com.zjitc.lostandfound_api.mapper.AdminMapper;
import com.zjitc.lostandfound_api.mapper.ItemMapper;
import com.zjitc.lostandfound_api.mapper.UserMapper;
import com.zjitc.lostandfound_api.service.AdminService;
import com.zjitc.lostandfound_api.service.FileService;
import com.zjitc.lostandfound_api.service.ItemService;
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
    @Resource
    ItemService itemService;
    @Resource
    FileService fileService;
    @Resource
    ItemMapper itemMapper;

    @Test
    void contextLoads() {
        EncodeUtil encodeUtil = new EncodeUtil();
        System.out.println(encodeUtil.Md5Encode("admin123"));
    }
    @Test
    void test(){
        System.out.println(adminService.findCategory());
    }
    @Test
    void test2(){
        System.out.println(fileService.getAll());
    }
    @Test
    void test3(){
        System.out.println(itemService.findAll());
    }@Test
    void test4(){
        System.out.println(itemMapper.getCategoriesByItemId(28));
    }

}
