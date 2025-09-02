package com.alves.microservice_hexagonal_arch.adapters.out;

import com.alves.microservice_hexagonal_arch.application.ports.out.SendCpfValidationOutputPort;
import org.springframework.kafka.core.KafkaTemplate;

public class SendCpfValidationAdapter implements SendCpfValidationOutputPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
