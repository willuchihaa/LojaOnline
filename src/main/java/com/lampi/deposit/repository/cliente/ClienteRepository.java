package com.lampi.deposit.repository.cliente;


import org.springframework.data.jpa.repository.JpaRepository;

import com.lampi.deposit.model.cliente.Cliente;
import com.lampi.deposit.model.usuario.Usuario;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    Cliente getReferenceById(Long nome);

    void save(Usuario usuario);






}
