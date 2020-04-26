package com.lsw.prac;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ServletComponentScan
@Slf4j
//@EnableAspectJAutoProxy // 这个注解可以不加
public class PracApplication {

    public static void main(String[] args) {
        log.info("prac 正在启动.............");
        SpringApplication.run(PracApplication.class, args);
    }

}
