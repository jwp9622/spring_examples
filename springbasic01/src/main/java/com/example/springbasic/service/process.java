package com.example.springbasic.service;

import org.springframework.stereotype.Service;

@Service
public class process {


    public String process1(String a, String b){
        System.out.println("Service process1");
        String aaa= "return value";
        return aaa;
    }

    public String process2(){
        System.out.println("Service process2");
        return "";
    }

}
