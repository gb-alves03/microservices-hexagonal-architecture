package com.alves.microservice_hexagonal_arch.adapters.out;

import com.alves.microservice_hexagonal_arch.adapters.out.client.FindAddressByZipCodeClient;
import com.alves.microservice_hexagonal_arch.adapters.out.client.mapper.AddressResponseMapper;
import com.alves.microservice_hexagonal_arch.application.core.domain.Address;
import com.alves.microservice_hexagonal_arch.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;
    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient,
                                       AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = this.findAddressByZipCodeClient.find(zipCode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
