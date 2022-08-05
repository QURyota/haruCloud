package com.ryota.normal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Ryota
 * @create 2022/8/5 22:15
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.ryota.*")
public class NormalApplication {
    public static void main(String[] args) {
        SpringApplication.run(NormalApplication.class,args);
    }
}
