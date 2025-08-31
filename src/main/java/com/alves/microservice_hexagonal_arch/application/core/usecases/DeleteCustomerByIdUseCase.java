package com.alves.microservice_hexagonal_arch.application.core.usecases;

import com.alves.microservice_hexagonal_arch.application.ports.in.DeleteCustomerByIdInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.in.FindCustomerByIdInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort =deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        this.findCustomerByIdInputPort.find(id);
        this.deleteCustomerByIdOutputPort.delete(id);
    }
}
