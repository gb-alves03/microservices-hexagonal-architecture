package com.alves.microservice_hexagonal_arch.application.core.usecases;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.ports.in.FindCustomerByIdInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {
        return this.findCustomerByIdOutputPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
