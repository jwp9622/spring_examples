package com.example.springbasic.dto;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Book {
    public String name;
    public String title;

    public int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void publish(){
        System.out.println("publish ==> 이름:"+this.name+",제목:"+this.title+", 가격"+this.price);
    }

    public void start(){
        System.out.println("connect call");
    }
    public void last(){
        System.out.println("disconnect call");
    }
    @PostConstruct
    public void init(){
        System.out.println("----init----");
        start();
    }
    @PreDestroy
    public void close(){
        System.out.println("----close----");
        last();
    }
}
