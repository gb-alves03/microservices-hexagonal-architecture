package com.alves.microservice_hexagonal_arch.config;

import com.alves.microservice_hexagonal_arch.adapters.out.FindCustomerByIdAdapter;
import com.alves.microservice_hexagonal_arch.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
