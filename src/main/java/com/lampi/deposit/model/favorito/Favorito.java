package com.lampi.deposit.model.favorito;

import java.io.Serializable;

import com.lampi.deposit.model.item.ItensData;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "favoritos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Favorito implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    
    public Favorito(FavoritoData data){
        this.nome = data.nome();
    }
    public void AdicionarFavorito(FavoritoData data){
        this.nome = data.nome();
    }
    public void RemoverFavorito(FavoritoData data){
        this.nome = data.nome();
    }
    public void updateFavorito(FavoritoData data){
        this.nome = data.nome();
    }

}







