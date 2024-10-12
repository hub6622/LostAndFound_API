package com.zjitc.lostandfound_api;

import com.zjitc.lostandfound_api.utils.EncodeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LostAndFoundApiApplicationTests {

    @Test
    void contextLoads() {
        EncodeUtil encodeUtil = new EncodeUtil();
        System.out.println(encodeUtil.Md5Encode("admin123"));
    }

}
