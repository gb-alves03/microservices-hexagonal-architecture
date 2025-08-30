package com.alves.microservice_hexagonal_arch.adapters.out.client.mapper;

import com.alves.microservice_hexagonal_arch.adapters.out.client.response.AddressResponse;
import com.alves.microservice_hexagonal_arch.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
