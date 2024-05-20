package com.lampi.deposit.model.cliente;

public record ClienteDataResumo(Long id, String nome, String itens) {

    public ClienteDataResumo(Cliente cliente){
    this(cliente.getId(),cliente.getNome(),cliente.getItens());
}
}
