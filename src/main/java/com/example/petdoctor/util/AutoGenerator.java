package com.example.petdoctor.util;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.nio.file.Paths;

public class AutoGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/pet_doctor?useUnicode=true&characterEncoding=UTF-8&useSSL=false", "root", "1933")
                .globalConfig(builder -> builder
                        .author("djy")
                        .enableSwagger() //开启 swagger 模式
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.example.petdoctor")
                        .entity("pojo")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .xml("mapper.xml")
                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }


}
