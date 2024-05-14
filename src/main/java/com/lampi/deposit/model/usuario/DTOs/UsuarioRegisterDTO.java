package com.lampi.deposit.model.usuario.DTOs;

import com.lampi.deposit.model.usuario.login.UsuarioRole;

import jakarta.validation.constraints.NotNull;

public record UsuarioRegisterDTO(
@NotNull String username,
@NotNull String password, 
UsuarioRole role) {
    
}
