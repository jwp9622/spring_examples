package com.example.springbasic.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springbasic.beans")  //(basePackages = {"com.exmaple.springbasic.beans"})
public class AppConfig {

}
