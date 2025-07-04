package com.example.springbasic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.example.springbasic")  //(basePackages = {"com.exmaple.springbasic.beans"})
@EnableAspectJAutoProxy
public class AppConfig {
}
