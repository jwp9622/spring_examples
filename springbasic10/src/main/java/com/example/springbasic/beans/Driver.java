package com.example.springbasic.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    private String name = "홍길동";
    private final Car car;

    public Driver(@Lazy Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "차의 주인은 :" +name;
    }
}
