package com.example.springbasic.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sns{
    //@Value("${Sns.accessKey}")
    @Value("${Sns.accessKey}")
    public String accessKey;

    public String getAccessKey() {
        return accessKey;
    }
}
