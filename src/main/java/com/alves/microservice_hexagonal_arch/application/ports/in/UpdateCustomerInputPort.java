package com.alves.microservice_hexagonal_arch.application.ports.in;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
