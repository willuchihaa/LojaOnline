package com.lampi.deposit.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.DadosCadastrosItens;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/itens")

public class Escola {
    @PostMapping(value = "/")
    public String Cadastrar (@RequestBody DadosCadastrosItens dados) {
        System.out.println(dados);
        return null;

    }
    

    
}
