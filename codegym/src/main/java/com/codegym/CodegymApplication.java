package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CodegymApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodegymApplication.class, args);
        BCryptPasswordEncoder bCryptPasswordEncoder =new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123"));
    }

}
