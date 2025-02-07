package com.test.testtechnique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestTechniqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTechniqueApplication.class, args);
    }

}
