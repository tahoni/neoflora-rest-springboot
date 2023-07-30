package za.co.neoflora.neoflorarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "za.co.neoflora.neofloradao")
@SpringBootApplication
public class NeofloraRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeofloraRestApplication.class, args);
	}

}
