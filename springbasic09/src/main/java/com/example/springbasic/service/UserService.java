package com.example.springbasic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    public void registerUser(String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("암호화된 비밀번호: " + encodedPassword);
    }

    // 로그인
    public boolean login(String inputPassword, String storedEncodedPassword) {
        boolean matches = passwordEncoder.matches(inputPassword, storedEncodedPassword);
        System.out.println("비밀번호 일치 여부: " + matches);
        return matches;
    }
}
