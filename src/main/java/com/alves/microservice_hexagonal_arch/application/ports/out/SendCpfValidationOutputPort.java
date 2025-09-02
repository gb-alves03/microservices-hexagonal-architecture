package com.alves.microservice_hexagonal_arch.application.ports.out;

public interface SendCpfValidationOutputPort {

    void send(String cpf);
}
