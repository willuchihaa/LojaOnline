package com.lampi.deposit.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lampi.deposit.model.usuario.Usuario;


public interface UsuarioRepository extends JpaRepository <Usuario, Long> //passando 2 objetos, chave primaria
{

    Usuario findByNome(String username);

    Usuario save(Optional<Usuario> user);

    Usuario findBysenha(String senha);


}
