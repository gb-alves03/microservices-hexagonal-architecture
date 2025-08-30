package com.alves.microservice_hexagonal_arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceHexagonalArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceHexagonalArchApplication.class, args);
	}

}
