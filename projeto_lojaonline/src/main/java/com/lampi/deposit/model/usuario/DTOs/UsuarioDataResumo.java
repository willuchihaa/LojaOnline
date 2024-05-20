package com.lampi.deposit.model.usuario.DTOs;

import com.lampi.deposit.model.usuario.Usuario;

public record UsuarioDataResumo(String nome, String email, String senha) {
    public UsuarioDataResumo(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }
}
