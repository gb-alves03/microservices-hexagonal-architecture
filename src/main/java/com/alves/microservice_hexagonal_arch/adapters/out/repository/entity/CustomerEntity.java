package com.alves.microservice_hexagonal_arch.adapters.out.repository.entity;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.entity.utils.ValidCpf;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEntity address;
    @ValidCpf
    private String cpf;

}
