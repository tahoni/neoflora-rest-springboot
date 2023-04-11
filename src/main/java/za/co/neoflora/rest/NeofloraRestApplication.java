package za.co.neoflora.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.neoflora"})
public class NeofloraRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeofloraRestApplication.class, args);
	}

}
