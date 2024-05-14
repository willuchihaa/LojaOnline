package com.lampi.deposit.model.cliente;
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

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Cliente implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
        private String itens;

    public Cliente(ClienteData data){
        this.nome = data.nome();

    }
    public void atualizar(ClienteData data){
        this.nome = data.nome();

    }
    public void update(ClienteData data) {
        this.nome = data.nome();

    }
    public void PegarNomeCliente(ClienteData data){
        this.nome = data.nome();
    }
}
