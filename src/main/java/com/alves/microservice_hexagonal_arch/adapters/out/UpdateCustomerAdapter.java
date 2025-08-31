package com.alves.microservice_hexagonal_arch.adapters.out;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.CustomerRepository;
import com.alves.microservice_hexagonal_arch.adapters.out.repository.mapper.CustomerEntityMapper;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        var customerEntity = this.customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(customerEntity);
    }
}
