package com.liurq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author:hyz
 * @Date:2021-09-20
 * @Desc:
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.liurq.**.mapper"})
public class TeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class,args);
    }
}
