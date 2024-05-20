package com.lampi.deposit.model.carrinho;

public record CarrinhoData(String nome,int preco, Integer quantidade) {
    public CarrinhoData(Carrinho carrinho){
    this(carrinho.getNome(),carrinho.getPreco(),carrinho.getQuantidade());
    }
    
}
