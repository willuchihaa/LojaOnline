package com.lampi.deposit.auth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.item.Item;
import com.lampi.deposit.model.item.ItensData;
import com.lampi.deposit.repository.itens.ItemRepository;

import jakarta.transaction.Transactional;



@RestController
@RequestMapping("/item")
public class ItemController {
@Autowired  
private ItemRepository itemRepository;

@PostMapping
@Transactional
public void addItem(@RequestBody ItensData data, boolean isAdmin) {
    if(isAdmin) {
        Item i = new Item(data);
        itemRepository.save(i);
        System.out.println("Item salvo com sucesso\n"+data);
    }else{
        throw new RuntimeException("Somente admins podem adicionar itens");
    }
}
@GetMapping
@Transactional
public Item PesquisarNome(String nome) {
        Optional<Item> item = itemRepository.findByNome(nome);
        if(item.isPresent()) {
            return item.get();
     }
     return null;
}
@GetMapping("/{id}")
@Transactional
public Item BuscarPorId(Long id) {
    Optional<Item> item = itemRepository.findById(id);
    return item.orElse(null);
}
@DeleteMapping("/{id}")
@Transactional
public void DeletarItem(Long id, boolean isAdmin) {
    if(isAdmin) {
        itemRepository.deleteById(id);
    }else{
        throw new RuntimeException("Você não tem permissão para deletar um item");
    }
}
}
