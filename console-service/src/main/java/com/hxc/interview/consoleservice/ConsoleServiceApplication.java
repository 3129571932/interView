package com.hxc.interview.consoleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.hxc.interview.consoleservice", "com.hxc.interView.common"})
public class ConsoleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsoleServiceApplication.class, args);
    }

}
