package com.alves.microservice_hexagonal_arch.adapters.out.repository;

import com.alves.microservice_hexagonal_arch.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

}
