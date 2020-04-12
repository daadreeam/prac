package com.lsw.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ServletComponentScan
public class PracApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracApplication.class, args);
    }

}
