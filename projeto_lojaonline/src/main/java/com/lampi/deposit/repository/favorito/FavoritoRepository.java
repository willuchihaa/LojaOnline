package com.lampi.deposit.repository.favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lampi.deposit.model.favorito.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {
    Favorito getReferenceById(Long nome);
}

//as variaveis no favorito.java, tavam erradas na ordem, por isso eu
//so conseguia por string no Jparepository
//a ordem dasd declaracoes aparentemente importa 
    

