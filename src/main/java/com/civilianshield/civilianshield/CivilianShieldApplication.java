package com.civilianshield.civilianshield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.civilianshield.civilianshield")
public class CivilianShieldApplication {
    public static void main(String[] args) {
        SpringApplication.run(CivilianShieldApplication.class, args);
    }
}