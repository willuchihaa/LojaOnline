package com.lampi.deposit.model.item;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String nome;
    private int preco;
    private Integer quantidade;
    private LocalDate dataCadastro = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private ItensCategoria categoria;

    public Item(ItensData data){
        this.nome = data.nome();
        this.preco = data.preco();
        this.quantidade = data.quantidade();
    }
    public void Cadastrar(ItensData data){
        this.nome = data.nome();
        this.preco = data.preco();
        this.quantidade = data.quantidade();
        
    }
    public void PesquisarNome(ItensData data){
        this.nome = data.nome();
    }
    public void BuscaPorId(ItensData data){
        this.id = data.id();
    }
}
