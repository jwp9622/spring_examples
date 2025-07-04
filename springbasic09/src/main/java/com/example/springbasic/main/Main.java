package com.example.springbasic.main;

import com.example.springbasic.beans.ProtoType;
import com.example.springbasic.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
public class Singleton {

    // 1. static으로 유일한 인스턴스를 저장할 변수 선언
    private static Singleton instance;

    // 2. 생성자를 private으로 해서 외부에서 new로 생성 못하게 함
    private Singleton() {
        System.out.println("싱글톤 인스턴스 생성!");
    }

    // 3. 인스턴스를 반환하는 public static 메서드 제공
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // 최초 1회만 생성됨
        }
        return instance;
    }

    // 예시 메서드
    public void sayHello() {
        System.out.println("안녕하세요! 싱글톤입니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.sayHello();

        // 동일한 인스턴스인지 확인
        System.out.println(s1 == s2);  // true
    }
}
*/



//9. 싱글톤 빈 스코프와 프로토타입 빈 스코프 구현하기
public class Main {

    public static void main(String[] args) {

        // 1. static으로 유일한 인스턴스를 저장할 변수 선언
        private static Singleton instance;

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //context.getBean(PasswordEncoder.class);

        //싱글톤 예제
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("원문: " + rawPassword);
        System.out.println("암호화된 비밀번호: " + encodedPassword);

        boolean result = passwordEncoder.matches("1234", encodedPassword);
        System.out.println("비밀번호 동일여부 " + result);  // true

        //프로토타입 예제

        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);

        ProtoType prototype1 = context2.getBean(ProtoType.class);
        ProtoType prototype2 = context2.getBean(ProtoType.class);
        System.out.println("prototype1="+prototype1);
        System.out.println("prototype1="+prototype2);

    }
}

