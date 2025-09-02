package com.alves.microservice_hexagonal_arch.adapters.in.consumer.mapper;

import com.alves.microservice_hexagonal_arch.adapters.in.consumer.message.CustomerMessage;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
