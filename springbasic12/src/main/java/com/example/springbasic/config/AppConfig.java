package com.example.springbasic.config;

import com.example.springbasic.beans.Car;
import com.example.springbasic.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public Car car(){
        Car c = new Car();
        c.setName("그랜저");
        return c;
    }

    @Bean
    public Person driver(Car car){
        Person d = new Person();
        d.setName("이철수");
        d.setCar(car);
        return d;
    }

}
