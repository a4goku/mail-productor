package com.jdmail.mailproductor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan
@ComponentScan({"com.jdmail.mail.*"})
public class MainConfig {
}
