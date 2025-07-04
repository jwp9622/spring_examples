package com.example.springbasic.main;

import com.example.springbasic.bean.Sns;
import com.example.springbasic.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

//4. 프로퍼티 파일을 이용한 환경 설정 주입하기
public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        var sns = context.getBean(Sns.class);

        String key = sns.getAccessKey();
        System.out.println("key="+key);
    }
}

