package za.co.neoflora.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.neoflora.dao"})
public class NeofloraRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeofloraRestApplication.class, args);
	}

}
