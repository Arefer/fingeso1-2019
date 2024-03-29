package com.symbiose.proposals_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProposalsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProposalsManagerApplication.class, args);
    }


    @RequestMapping(value = "/")
    public String hello(){
        return "Hello, World!";
    }
}
