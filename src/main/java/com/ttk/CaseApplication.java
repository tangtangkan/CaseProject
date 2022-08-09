package com.ttk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 开启事务支持，开启之后在Service方法上添加注解@Transactional便可
@EnableTransactionManagement
@SpringBootApplication
// 这样就不用在每个dao加入@Mapper注释了
@MapperScan("com.ttk.dao")
public class CaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseApplication.class, args);
    }

}
