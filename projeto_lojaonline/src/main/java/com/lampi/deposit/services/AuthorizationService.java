package com.lampi.deposit.services;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.lampi.deposit.model.usuario.DetalhesUsuario;
import com.lampi.deposit.model.usuario.Usuario;
import com.lampi.deposit.model.usuario.DTOs.UsuarioRegisterDTO;
import com.lampi.deposit.model.usuario.login.AuthenticationDTO;
import com.lampi.deposit.model.usuario.token.UsuarioAutorization;
import com.lampi.deposit.repository.usuario.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class AuthorizationService implements UserDetailsService{
    @Autowired
    private ApplicationContext context;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository usuarioRepo;

    private AuthenticationManager authenticationManager;

    // sobrescreve algus metodos do userdetails<LoadByUsername>
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepo.findByNome(username);
        DetalhesUsuario ud = new DetalhesUsuario(u);
        System.out.println(u.getSenha());
       return ud;
    }
    /*
    public ResponseEntity<UsuarioAutorization> login(@RequestBody @Valid AuthenticationDTO authenticationDTO){
        //aqui cria um bean pro authentication do tipo classe
        authenticationManager = context.getBean(AuthenticationManager.class); // mudei o <" ">

        // aqui declara uma variavel do token de acordo com as instancias
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password()); // tava username
        var auth = this.authenticationManager.authenticate(usernamePassword);

        //aqui chama o metodo criar token e cria ele no detalhesusuario
        var token = tokenService.CriarToken((DetalhesUsuario)auth.getPrincipal());

        return ResponseEntity.ok(new UsuarioAutorization(token));

    }
    public ResponseEntity<UsuarioAutorization> register(@RequestBody UsuarioRegisterDTO usuarioRegisterDTO){
        if (this.usuarioRepo.findByEmail(usuarioRegisterDTO.email()) != null)return ResponseEntity.badRequest().build();
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioRegisterDTO.password());

        DetalhesUsuario newUser = new DetalhesUsuario(usuarioRegisterDTO.email(),senhaCriptografada, usuarioRegisterDTO.role());
        newUser.setCreatedAt(new Date(System.currentTimeMillis()));
        this.usuarioRepo.save(newUser);
        return ResponseEntity.ok().build();
    } */
}