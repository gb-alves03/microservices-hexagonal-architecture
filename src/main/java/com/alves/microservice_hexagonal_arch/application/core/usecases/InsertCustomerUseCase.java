package com.alves.microservice_hexagonal_arch.application.core.usecases;

import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.ports.in.InsertCustomerInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.FindAddressByZipCodeOutputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.InsertCustomerOutputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.SendCpfValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfValidationOutputPort sendCpfValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfValidationOutputPort sendCpfValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfValidationOutputPort = sendCpfValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        this.insertCustomerOutputPort.insert(customer);
        sendCpfValidationOutputPort.send(customer.getCpf());
    }
}
