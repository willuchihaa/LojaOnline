package com.lampi.deposit.model.carrinho;

public record CarrinhoDataResumo(Long id, String nome) {
    public CarrinhoDataResumo(Carrinho carrinho){
    this(carrinho.getId(), carrinho.getNome());
    }
}
