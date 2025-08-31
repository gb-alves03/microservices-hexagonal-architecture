package com.alves.microservice_hexagonal_arch.application.ports.out;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
