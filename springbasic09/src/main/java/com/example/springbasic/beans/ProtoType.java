package com.example.springbasic.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProtoType {
    ProtoType(){
        System.out.println("ProtoType");
    }

}
