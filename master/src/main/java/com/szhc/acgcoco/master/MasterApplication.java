package com.szhc.acgcoco.master;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

@SpringBootApplication
public class MasterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class, args);
    }

    @Component
    public class ApplicationRunnerImpl implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments args) throws Exception {
            ShellRPC.inti("C:\\server.properties");
            ShellRPC.issue("H:\\Follow\\acgcoco\\controller-api\\target\\api.jar","api");
           // ShellRPC.issue("H:\\Follow\\acgcoco\\controller-api\\target\\api.jar","backend");
            System.out.println("成功.......................................................................");
        }
    }
}
