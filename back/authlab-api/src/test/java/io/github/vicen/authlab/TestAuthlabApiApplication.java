package io.github.vicen.authlab;

import org.springframework.boot.SpringApplication;

public class TestAuthlabApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthLabApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
