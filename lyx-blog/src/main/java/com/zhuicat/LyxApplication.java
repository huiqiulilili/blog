package com.zhuicat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhuicat
 * @since 2022/9/13 22:42
 */
@SpringBootApplication
@MapperScan("com.zhuicat.mapper")
public class LyxApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyxApplication.class,args);
    }
}
