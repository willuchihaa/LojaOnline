package com.lampi.deposit.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.usuario.DetalhesUsuario;
import com.lampi.deposit.model.usuario.DTOs.UsuarioRegisterDTO;
import com.lampi.deposit.model.usuario.login.AuthenticationDTO;
import com.lampi.deposit.model.usuario.token.UsuarioLoginToken;
import com.lampi.deposit.services.TokenService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;


    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity  login(@RequestBody @Valid AuthenticationDTO data){
         UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(data.nome(), data.password());
        Authentication auth = authManager.authenticate(upat);

       String token = tokenService.CriarToken((DetalhesUsuario) auth.getPrincipal());

        return ResponseEntity.ok(new UsuarioLoginToken(token)); // ou usuariologintoken
    }
    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioRegisterDTO data){
        {
            return ResponseEntity.ok().build();
        }
    }


 
    }
    
