package com.alves.microservice_hexagonal_arch.adapters.in.controller.mapper;

import com.alves.microservice_hexagonal_arch.adapters.in.controller.request.CustomerRequest;
import com.alves.microservice_hexagonal_arch.adapters.in.controller.response.CustomerResponse;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
