package com.alves.microservice_hexagonal_arch.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerRequest {

    @NotBlank(message = "Name must not be null")
    private String name;
    @NotBlank(message = "CPF must not be null")
    private String cpf;
    @NotBlank(message = "Zip Code must not be null")
    private String zipCode;
}
