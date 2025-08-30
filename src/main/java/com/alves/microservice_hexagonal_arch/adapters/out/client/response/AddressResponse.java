package com.alves.microservice_hexagonal_arch.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;
    private String city;
    private String state;
}
