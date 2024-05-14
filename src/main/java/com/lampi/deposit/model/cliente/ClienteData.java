package com.lampi.deposit.model.cliente;

public record ClienteData(Long id, String nome) {
    public ClienteData(Cliente cliente){
        this(cliente.getId(), 
        cliente.getNome()
        );
    }
}
