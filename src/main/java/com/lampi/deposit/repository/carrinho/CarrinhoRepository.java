package com.lampi.deposit.repository.carrinho;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lampi.deposit.model.carrinho.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long>{
    Carrinho getReferenceById(Long nome);
}
