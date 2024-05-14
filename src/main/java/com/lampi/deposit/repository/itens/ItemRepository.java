package com.lampi.deposit.repository.itens;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lampi.deposit.model.item.Item;
import com.lampi.deposit.model.item.ItensData;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByNome(String nome);

    void save(ItensData data);

    
}
