package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //para que la aplicacion web se inicie, tambien se necesita la dependencia Test
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}