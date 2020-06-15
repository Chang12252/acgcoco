package com.szhc.acgcoco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.szhc.acgcoco.dao"})
@EnableTransactionManagement
@EnableScheduling
public class ControllerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerBackendApplication.class, args);
    }

}
