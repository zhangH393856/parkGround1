package com.park;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.park.mapper")
@SpringBootApplication
public class ParkGround1Application {

    public static void main(String[] args) {
        SpringApplication.run(ParkGround1Application.class, args);
    }

}
