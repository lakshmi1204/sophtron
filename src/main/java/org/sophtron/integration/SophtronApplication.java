package org.sophtron.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class SophtronApplication {

    public static void main(String[] args) {
        SpringApplication.run(SophtronApplication.class, args);
    }

}
