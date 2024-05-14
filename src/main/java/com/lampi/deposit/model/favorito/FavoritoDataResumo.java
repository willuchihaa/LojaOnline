package com.lampi.deposit.model.favorito;

public record FavoritoDataResumo(String nome, Long id) {
    public FavoritoDataResumo(Favorito favorito){
        this(favorito.getNome(), favorito.getId());
    }
    
}
