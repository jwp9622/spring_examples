package com.example.springbasic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BookManagerService {
    @Autowired
    private BookInterface bookInterface;

    public void process(){
        bookInterface.publish();
    }
}
