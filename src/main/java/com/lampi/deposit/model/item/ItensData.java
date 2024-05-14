package com.lampi.deposit.model.item;

import java.time.LocalDate;

public record ItensData(Long id, String nome, int preco, Integer quantidade, LocalDate dataCadastro,ItensCategoria categoria ) {
    public ItensData(Item item){
        this(item.getId(),
        item.getNome(),
        item.getPreco(), 
        item.getQuantidade(),
        item.getDataCadastro(),
        item.getCategoria());
    }

    public boolean existsById(Long id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }
    
}
