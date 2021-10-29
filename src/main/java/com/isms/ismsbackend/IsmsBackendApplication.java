package com.isms.ismsbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.isms.ismsbackend.dao")
public class IsmsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IsmsBackendApplication.class, args);
    }

}
