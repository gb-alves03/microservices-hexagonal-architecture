package com.alves.microservice_hexagonal_arch.application.ports.in;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
