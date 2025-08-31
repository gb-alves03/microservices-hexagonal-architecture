package com.alves.microservice_hexagonal_arch.adapters.in.controller;

import com.alves.microservice_hexagonal_arch.adapters.in.controller.mapper.CustomerMapper;
import com.alves.microservice_hexagonal_arch.adapters.in.controller.request.CustomerRequest;
import com.alves.microservice_hexagonal_arch.adapters.in.controller.response.CustomerResponse;
import com.alves.microservice_hexagonal_arch.application.core.domain.Customer;
import com.alves.microservice_hexagonal_arch.application.core.usecases.InsertCustomerUseCase;
import com.alves.microservice_hexagonal_arch.application.ports.in.DeleteCustomerByIdInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.in.FindCustomerByIdInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.in.InsertCustomerInputPort;
import com.alves.microservice_hexagonal_arch.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;
    private final DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerUseCase insertCustomerInputPort,
                              FindCustomerByIdInputPort findCustomerByIdInputPort,
                              UpdateCustomerInputPort updateCustomerInputPort,
                              DeleteCustomerByIdInputPort deleteCustomerByIdInputPort,
                              CustomerMapper customerMapper) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerByIdInputPort = deleteCustomerByIdInputPort;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest request) {
        var customer = this.customerMapper.toCustomer(request);
        this.insertCustomerInputPort.insert(customer, request.getZipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
        var customer = this.findCustomerByIdInputPort.find(id);

        return ResponseEntity.ok().body(this.customerMapper.toCustomerResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, CustomerRequest request) {
        Customer customer = this.customerMapper.toCustomer(request);
        customer.setId(id);
        this.updateCustomerInputPort.update(customer, request.getZipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {
        this.deleteCustomerByIdInputPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
