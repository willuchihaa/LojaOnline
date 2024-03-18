package com.lampi.deposit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @PostMapping("/hello") // este é o endereço da pagina (localhost:8080)
    public String helloWorld(){
        return "pagina masssa"; // isso é a mensagem retornada na pagina 
    }    
}
