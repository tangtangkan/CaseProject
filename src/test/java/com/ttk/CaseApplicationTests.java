package com.ttk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// 因为springbootTest启动时不会启动服务器，所以websocket就会报错，这个时候需要在注解中添加webEnvironment，给wevsocket提供测试环境
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CaseApplicationTests {

    @Test
    void test1() {
        System.out.println("哈哈");
    }

}
