package com.alves.microservice_hexagonal_arch.application.ports.out;

import com.alves.microservice_hexagonal_arch.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
