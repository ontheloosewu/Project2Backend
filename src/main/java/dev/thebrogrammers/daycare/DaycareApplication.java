package dev.thebrogrammers.daycare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.thebrogrammers"})
@EntityScan(basePackages = {"dev.thebrogrammers.entities"})
@EnableJpaRepositories(basePackages = {"dev.thebrogrammers.repos"})
@EnableMongoRepositories(basePackages = "dev.thebrogrammers.repos")
public class DaycareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaycareApplication.class, args);
	}

}
