package ru.kpfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 14.02.2018
 *
 * @author Robert Bagramov.
 */
@ComponentScan("ru.kpfu")
@SpringBootApplication
public class CheckInApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckInApplication.class, args);
    }
}
