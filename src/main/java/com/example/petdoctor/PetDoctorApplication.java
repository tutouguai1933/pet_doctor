package com.example.petdoctor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages="com.example.petdoctor")
@MapperScan("com.example.petdoctor.mapper")
public class PetDoctorApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetDoctorApplication.class, args);
    }
}
