package com.alves.microservice_hexagonal_arch.application.core.domain;

public class Customer {

    private String id;
    private String name;
    private Address address;
    private String cpf;

    public Customer() {}

    public Customer(String id, String name, Address address, String cpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
