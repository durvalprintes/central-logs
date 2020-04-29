package com.codenation.aceleradev;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AceleradevApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceleradevApplication.class, args);
	}

	@RestController
	@RequestMapping(path = "/api")
	class Main {

		@GetMapping
		public Map<String, String> root() {
			return Collections.singletonMap("API", "OK");
		}

	}
}
