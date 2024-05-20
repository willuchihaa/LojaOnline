package com.lampi.deposit.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.lampi.deposit.model.cliente.Cliente;
import com.lampi.deposit.model.cliente.ClienteData;
import com.lampi.deposit.model.cliente.ClienteDataResumo;
import com.lampi.deposit.repository.cliente.ClienteRepository;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepo;
    
    
    @ApiResponses(value = @ApiResponse (responseCode = "200", description = "Pega todos os clientes e deixa em formato de lista"))
    @GetMapping
    public List<ClienteDataResumo> PegarTodosClientes(){
        return clienteRepo.findAll().stream().map(ClienteDataResumo::new).toList();
    } //convetrte todo o get e o construtor, pra uma lista
    
    @ApiResponses(value = @ApiResponse (responseCode = "200", description = "Pega um unico cliente pelo seu id"))

    @GetMapping("/{id}")
    public ClienteData PegarCliente (@PathVariable Long id, HttpServletResponse res) {
        if(id != null && clienteRepo.existsById(id)){
            Cliente c = clienteRepo.getReferenceById(id);
            ClienteData cd = new ClienteData(c);
            return cd;
        }
        res.setStatus(204);
        return null;
    }
    @ApiResponses(value = @ApiResponse (responseCode = "200", description = "Salva o cliente no banco de dados"))

    @PostMapping
    @Transactional
    public void salvaCliente(@RequestBody ClienteData dados) {
        Cliente c = new Cliente(dados);
        clienteRepo.save(c);
    }
    @ApiResponses(value = @ApiResponse (responseCode = "200", description = "Deleta o cliente e suas informacoes apenas pelo id"))

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarCliente(@PathVariable Long id){
        if(id != null){
            clienteRepo.deleteById(id);
        }
    }
    @ApiResponses(value = @ApiResponse (responseCode = "200", description = "Atualiza as infoemacoes do cliente daso as tenha alterado"))

    @PutMapping("/{id}")
    @Transactional
    public void atualizarCliente(@PathVariable Long id, @RequestBody ClienteData dados){
        if(id != null){
            Cliente c = clienteRepo.getReferenceById(id);
            c.update(dados);
        }
    } 


    
}

