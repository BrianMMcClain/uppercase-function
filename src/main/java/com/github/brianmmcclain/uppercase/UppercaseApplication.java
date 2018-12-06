package com.github.brianmmcclain.uppercase;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UppercaseApplication {

	@Bean
    public Function<String, String> uppercase() {
		String pgUser = System.getProperty("PG_USER", "postgres");
		String pgPass = System.getProperty("PG_PASS", "defaultPass");
        return s -> s.toUpperCase() + " -- " + pgUser + "/" + pgPass;
    }
	public static void main(String[] args) {
		SpringApplication.run(UppercaseApplication.class, args);
	}
}
