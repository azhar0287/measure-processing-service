package com.qep.measureprocessingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeasureProcessingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(MeasureProcessingServiceApplication.class, args);
        System.out.println("Service has started");
    }

}
