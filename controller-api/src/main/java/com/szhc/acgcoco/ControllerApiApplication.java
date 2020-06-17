package com.szhc.acgcoco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.szhc.acgcoco.dao"})
@EnableTransactionManagement
@SpringBootApplication
public class ControllerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerApiApplication.class, args);
    }

}
