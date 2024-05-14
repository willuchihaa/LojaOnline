package com.lampi.deposit.model.usuario;

import com.lampi.deposit.model.usuario.login.UsuarioRole;

// isso importa todas as dependencias kkkk nao sabia
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario") // aparentemente tem que ter underline na table
// fazer conexo com mariadb tem q ter tabela

// isso pula a forma de fazer get e set
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nome")

public class Usuario {
    
    public static UsuarioRole UsuarioLogin;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // isso gera Id´s automaticamente
    @Column (name = "id_usuario")
    private Long id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "email")
    private String email;
    @Column (name = "senha")
    private String senha;

    @Enumerated(EnumType.STRING)
    public UsuarioRole UsuarioRole;

    public Usuario( Long id, String nome,String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
       
    }

    public String getUsername() {
    return this.nome;    }
  
}

