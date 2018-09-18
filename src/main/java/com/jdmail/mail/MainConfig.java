package com.jdmail.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//启用spring MVC
@EnableWebMvc
//声明此类为xml配置类
@Configuration
@ComponentScan({"com.jdmail.mail.*"})
@MapperScan(basePackages = "com.jdmail.mail.mapper")
public class MainConfig {
}
