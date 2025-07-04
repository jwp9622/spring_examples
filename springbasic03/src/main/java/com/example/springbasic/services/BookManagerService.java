package com.example.springbasic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class BookManagerService {
    @Autowired
    @Qualifier("Bbook")
    private BookInterface bookInterface;

    public void process(){
        bookInterface.publish();
    }
}
