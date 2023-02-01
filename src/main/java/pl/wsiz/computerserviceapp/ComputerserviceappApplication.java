package pl.wsiz.computerserviceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ComputerserviceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerserviceappApplication.class, args);
	}

}
