package com.ryota.sauser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ryota
 * @description
 * @date 2022/9/1 20:38
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.ryota.*")
public class SaUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SaUserApplication.class,args);
    }

}
