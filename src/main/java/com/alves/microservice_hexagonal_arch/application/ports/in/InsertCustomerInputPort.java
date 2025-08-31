package com.alves.microservice_hexagonal_arch.application.ports.in;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
