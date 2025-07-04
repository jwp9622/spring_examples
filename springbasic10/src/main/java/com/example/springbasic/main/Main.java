package com.example.springbasic.main;

import com.example.springbasic.beans.Car;
import com.example.springbasic.beans.Driver;
import com.example.springbasic.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//10. 순환 의존성 해결하기
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver d = context.getBean(Driver.class);
        System.out.println("운전자 : " + d.getName());
        System.out.println("자동차 : " + d.getCar());

        Car c = context.getBean(Car.class);
        System.out.println("자동차 : " + c.getName());
        System.out.println("주인 : " + c.getDriver());


    }
}

