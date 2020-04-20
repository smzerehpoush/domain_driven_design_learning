package com.mahdiyar.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Seyyed Mahdiyar Zerehpoush
 */
@SpringBootApplication(scanBasePackages = "com.mahdiyar.ddd")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
