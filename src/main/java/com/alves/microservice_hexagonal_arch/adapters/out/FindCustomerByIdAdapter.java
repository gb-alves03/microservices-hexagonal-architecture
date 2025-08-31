package com.alves.microservice_hexagonal_arch.adapters.out;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.CustomerRepository;
import com.alves.microservice_hexagonal_arch.adapters.out.repository.mapper.CustomerEntityMapper;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository,
                                   CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }


    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = this.customerRepository.findById(id);

        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
