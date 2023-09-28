package com.peaksoft.gadgetaruimm6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class GadgetaruimM6Application {

    public static void main(String[] args) {
        SpringApplication.run(GadgetaruimM6Application.class, args);
    }

    @GetMapping("/")
    public String greetingPage() {
        return "<h1>Welcome to Gadgetarium-M5 Application!!!<h1/>";
    }
}
