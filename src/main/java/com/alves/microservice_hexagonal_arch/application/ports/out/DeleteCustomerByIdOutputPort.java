package com.alves.microservice_hexagonal_arch.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
