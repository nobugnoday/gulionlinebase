package com.atguigu.gulionline.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 设置一个启动类
@SpringBootApplication
// 当前启动类启动时默认扫描主程序所在的包以及包下的组件
// 指定当前启动类扫描的基本包，com.atguigu.gulionline.service
@ComponentScan(basePackages = {"com.atguigu.gulionline.service"})
public class ServiceEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class,args);
    }
}
