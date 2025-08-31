package com.alves.microservice_hexagonal_arch.adapters.out.repository.mapper;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.entity.CustomerEntity;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
