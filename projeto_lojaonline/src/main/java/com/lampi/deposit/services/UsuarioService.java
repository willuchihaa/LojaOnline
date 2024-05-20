package com.lampi.deposit.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lampi.deposit.model.usuario.Usuario;
import com.lampi.deposit.model.usuario.login.UsuarioData;

import com.lampi.deposit.repository.usuario.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;



    public Usuario save(@Valid UsuarioData usuarioData, @RequestParam boolean isAdmin) {
        Usuario usuario = new Usuario(null, null, null, null);
        usuario.setEmail(usuarioData.email());
        usuario.setNome(usuarioData.nome());
        usuario.setSenha(bCryptPasswordEncoder.encode(usuarioData.senha()));

        // if (usuarioRepository.existsById(usuario.getNome())) {
        // throw new DataIntegrityViolationException("esse usuario existe");
        // }

        if (isAdmin) {
            return usuarioRepository.save(usuario);
            
        }
        throw new EntityNotFoundException("nome de usuario nao foi encontrado");
    }

    public Usuario updateById(Long id, @Valid Usuario atualizarUser) {
        Optional<Usuario> user = usuarioRepository.findById(id);
        System.out.println(user.isPresent());
        if (user.isPresent()) {
            System.out.println(user.get().getNome());

            user.get().setNome(atualizarUser.getNome());
            user.get().setEmail(atualizarUser.getEmail());
            user.get().setSenha(bCryptPasswordEncoder.encode(atualizarUser.getSenha()));
            user.get().setUsuarioRole(atualizarUser.getUsuarioRole());

        }

        return usuarioRepository.save(user.get());
    }

    public Usuario deleteById(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("id de usuario nao encontrado");
        }
        return null;
    }

    public Usuario findByNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNome'");
    }
}
