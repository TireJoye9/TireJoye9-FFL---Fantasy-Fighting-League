package com.example.ffl;

import org.springframework.boot.SpringApplication;

public class TestFflFullStackWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(FFLWebAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
