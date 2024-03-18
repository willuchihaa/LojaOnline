package com.lampi.deposit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coisas")
public class MaterialEscolarController {
    @PostMapping
    public void cadastrar(@RequestBody String json){
        System.out.println(json);
    }    
}
