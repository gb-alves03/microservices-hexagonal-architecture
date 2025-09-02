package com.alves.microservice_hexagonal_arch.config;

import com.alves.microservice_hexagonal_arch.adapters.out.FindAddressByZipCodeAdapter;
import com.alves.microservice_hexagonal_arch.adapters.out.UpdateCustomerAdapter;
import com.alves.microservice_hexagonal_arch.application.core.usecases.FindCustomerByIdUseCase;
import com.alves.microservice_hexagonal_arch.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
