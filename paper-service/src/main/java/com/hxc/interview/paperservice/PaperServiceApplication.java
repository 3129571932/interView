package com.hxc.interview.paperservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.hxc.interview.paperservice", "com.hxc.interView"})
public class PaperServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaperServiceApplication.class, args);
    }

}
