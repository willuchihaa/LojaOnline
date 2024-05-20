package com.lampi.deposit.model.carrinho;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//receber do usuario o iten, quatidade e o codigo dele(ou id do produto)

@Entity
@Table(name = "carrinho")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Carrinho implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private int preco;
    private Integer quantidade;

    public Carrinho(CarrinhoData data){
       this.nome = data.nome();
       this.preco = data.preco();
        this.quantidade = data.quantidade();
    }
    public void atualizar(CarrinhoData data){
        this.nome = data.nome();
    }
    public void updatee(CarrinhoData data){
        this.nome = data.nome();
    }
    public void PegarItemNome(CarrinhoData data){
        this.nome = data.nome();
    }
}
