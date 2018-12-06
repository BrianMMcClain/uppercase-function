package com.github.brianmmcclain.uppercase;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UppercaseApplication {

	@Bean
    public Function<String, String> uppercase() {
		String pgUser = Optional.of(System.getenv("PG_USER")).orElse("defaultUser");
		String pgPass = Optional.of(System.getenv("PG_PASS")).orElse("defaultPass");
		
        return s -> s.toUpperCase() + " -- " + pgUser + "/" + pgPass;
    }
	public static void main(String[] args) {
		SpringApplication.run(UppercaseApplication.class, args);
	}
}
