package com.example.springbasic.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String name = "Sonata";

    @Override
    public String toString() {
        return name;
    }
}
