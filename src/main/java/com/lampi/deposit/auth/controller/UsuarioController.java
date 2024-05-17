package com.lampi.deposit.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.usuario.Usuario;
import com.lampi.deposit.model.usuario.login.UsuarioData;
import com.lampi.deposit.repository.cliente.ClienteRepository;
import com.lampi.deposit.repository.usuario.UsuarioRepository;
import com.lampi.deposit.services.UsuarioService;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{nome}")
    public ResponseEntity<Usuario>findByNome(@PathVariable(name = "nome")String nome){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByNome(nome));
        
    }
    @PostMapping
    public ResponseEntity<Usuario> save (@RequestBody UsuarioData usuario){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario, true));

    }catch (DataIntegrityViolationException ex) {
        throw new DataIntegrityViolationException("department not found");
    
    }
} 
@PutMapping("/{id}")
    public ResponseEntity<Usuario> updateById(@PathVariable("id") Long id, @Valid @RequestBody Usuario butarUsuario , boolean isAdmin){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.updateById(id,butarUsuario));

        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("id de usuario nao encontrado");
            
        } /*catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("department not found");
        }*/
    }
    @DeleteMapping("/{id}")
    @Transactional
    public Usuario deleteById(@PathVariable Long id){
        if (id != null) {
            System.out.println("Usuario apagado com sucesso!");
            usuarioService.deleteById(id);
        }
        return null;
    }

    /*@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> deleteById(@PathVariable Long id){
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deleteById(id)); // no service o return ta null
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("Nome de usuario nao encontrado ");
        }
    } */
    
}
