package com.alves.microservice_hexagonal_arch.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
