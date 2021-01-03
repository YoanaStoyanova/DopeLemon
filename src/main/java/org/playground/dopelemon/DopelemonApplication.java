package org.playground.dopelemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "org.playground.dopelemon.repository")
@SpringBootApplication
public class DopelemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(DopelemonApplication.class, args);
    }

}
