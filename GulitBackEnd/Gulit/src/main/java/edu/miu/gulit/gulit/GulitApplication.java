package edu.miu.gulit.gulit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class GulitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulitApplication.class, args);
    }

}
