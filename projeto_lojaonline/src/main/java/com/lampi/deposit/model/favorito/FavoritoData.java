package com.lampi.deposit.model.favorito;

public record FavoritoData(String nome) {
    public FavoritoData(Favorito favorito){
        this(favorito.getNome());
    } 
}
