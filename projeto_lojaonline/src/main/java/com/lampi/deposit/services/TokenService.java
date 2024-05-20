package com.lampi.deposit.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.lampi.deposit.model.usuario.DetalhesUsuario;

// Autenticacao com JWT 
// incluir login e restricao

@Service
public class TokenService {
   @Value("${jwt.secret}")

   private String chave = "senhadesenha";

   public String CriarToken(DetalhesUsuario usuario){
    try{
        Algorithm hmac256 = Algorithm.HMAC256(chave);//cria e define a variavel Algorithm como seu proprio metodo
        String chave = JWT.create() // aqui onde se cria o token de acordo com a "chave"
        .withIssuer("Auth")// nao sei direito oque botar aqui)
            .withSubject(usuario.getUsername())
                .withExpiresAt(genExpirantionInstant()) // horario de expiracao
                    .sign(hmac256); //assinatura do algoritimo
        return chave;
    }catch (JWTCreationException exception){
        throw new RuntimeException("erro ao criar token", exception); // caso de erro e nao consiga gerar
    }
}
public String PegarToken(String token){
    return JWT.decode(token).getSubject();
}

public String validarToken(String token){
    try{
        Algorithm hmac256 = Algorithm.HMAC256(chave); // aqui ja nao se cria o token, mas o retorna
        return JWT.require(hmac256)
        .withIssuer("Auth")
            .build()
                .verify(chave)
                    .getSubject();
    }catch (JWTVerificationException exception){
        return "";
    }
}

    //expiracao do toke
private Instant genExpirantionInstant() {
    return LocalDateTime
    .now()
    .plusHours(0)
    .toInstant(ZoneOffset.of("-03:00")); 
    }
}
