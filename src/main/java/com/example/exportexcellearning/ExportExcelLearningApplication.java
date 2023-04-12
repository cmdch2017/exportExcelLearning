package com.example.exportexcellearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kang
 */
@SpringBootApplication
@EnableScheduling
public class ExportExcelLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExportExcelLearningApplication.class, args);
    }

}
