package org.playground.dopelemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.playground.dopelemon.repository", "org.playground.dopelemon.model"})
@SpringBootApplication
@EnableAutoConfiguration
public class DopelemonApplication {
    public static void main(String[] args) {
        SpringApplication.run(DopelemonApplication.class, args);
    }

}
