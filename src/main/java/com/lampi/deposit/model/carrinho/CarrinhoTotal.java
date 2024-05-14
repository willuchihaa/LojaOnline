package com.lampi.deposit.model.carrinho;

public record CarrinhoTotal(int preco, Integer quantidade) {
    public CarrinhoTotal(Carrinho carrinho){
        this(carrinho.getPreco(),carrinho.getQuantidade());
        }
}
