package com.alves.microservice_hexagonal_arch.application.core.usecases;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.ports.out.FindAddressByZipCodeOutputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        this.insertCustomerOutputPort.insert(customer);
    }
}
