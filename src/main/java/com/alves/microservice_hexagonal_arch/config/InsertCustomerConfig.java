package com.alves.microservice_hexagonal_arch.config;

import com.alves.microservice_hexagonal_arch.adapters.out.FindAddressByZipCodeAdapter;
import com.alves.microservice_hexagonal_arch.adapters.out.InsertCustomerAdapter;
import com.alves.microservice_hexagonal_arch.application.core.usecases.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
    }
}
