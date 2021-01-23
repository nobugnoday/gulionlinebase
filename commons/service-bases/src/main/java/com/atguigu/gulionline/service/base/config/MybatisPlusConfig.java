package com.atguigu.gulionline.service.base.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  组件注解 （spring 容器会扫描并创建对象注入到容器中）：
 *      controller/service / repository /component /configuration
 *      代码中使用时需要使用注解描述当前类的作用类型
 *
 *  spring容器注入对象的方式：
 *      1 spring配置文件中通过<bean></bean>
 *      2 组件注解
 *      3 在组件类中通过@Bean注解标注的方法返回值
 *   自动填充类
 */
@Configuration
// 扫描mapper接口
@MapperScan(basePackages = {"com.atguigu.gulionline.service.*.mapper"})
public class MybatisPlusConfig {

    // 乐观锁拦截器
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    // 分页拦截器
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
