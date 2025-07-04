package com.example.springbasic.main;


import com.example.springbasic.beans.Car;
import com.example.springbasic.beans.Person;
import com.example.springbasic.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//12. 구성 파일에서 정의된 빈 간 관계 구현하기
public class Main {

  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(AppConfig.class);

    Car c = context.getBean(Car.class);
    Person d = context.getBean(Person.class);

    System.out.println("자동차 이름 : " + c.getName());
    System.out.println("운전자 이름 : " + d.getName());
    System.out.println("운전자의 자동차 이름 : " + d.getCar());

  }
}
