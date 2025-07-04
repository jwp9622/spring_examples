package com.example.springbasic.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private String name = "Sonata";

    private final Driver driver;

    public Car(@Lazy Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "차의 이름은 " + name;
    }
}
