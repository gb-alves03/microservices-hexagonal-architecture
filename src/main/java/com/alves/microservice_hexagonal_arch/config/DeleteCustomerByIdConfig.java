package com.alves.microservice_hexagonal_arch.config;

import com.alves.microservice_hexagonal_arch.adapters.out.DeleteCustomerByIdAdapter;
import com.alves.microservice_hexagonal_arch.application.core.usecases.DeleteCustomerByIdUseCase;
import com.alves.microservice_hexagonal_arch.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                               DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }
}
