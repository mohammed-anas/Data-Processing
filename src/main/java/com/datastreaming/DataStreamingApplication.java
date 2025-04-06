package com.datastreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.datastreaming.*")
public class DataStreamingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStreamingApplication.class, args);
    }

}
