package com.alves.microservice_hexagonal_arch.application.ports.out;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
