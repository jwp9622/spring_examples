package com.example.springbasic.main;

import com.example.springbasic.beans.Driver;
import com.example.springbasic.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//11. 애너테이션을 사용하여 빈 주입하기
public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Driver d = context.getBean(Driver.class);
        System.out.println("운전자 : " + d.getName());
        System.out.println("자동차 : " + d.getCar());

    }
}

