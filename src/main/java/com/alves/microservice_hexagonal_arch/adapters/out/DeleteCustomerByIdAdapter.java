package com.alves.microservice_hexagonal_arch.adapters.out;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.CustomerRepository;
import com.alves.microservice_hexagonal_arch.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void delete(String id) {
        this.customerRepository.deleteById(id);
    }
}
