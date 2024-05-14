package com.lampi.deposit.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.favorito.Favorito;
import com.lampi.deposit.model.favorito.FavoritoData;
import com.lampi.deposit.repository.favorito.FavoritoRepository;
import com.lampi.deposit.repository.itens.ItemRepository;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/favoritos")
public class FavoritoController {

    @Autowired // asdsad
    private FavoritoRepository favoritoRepo;
    @Autowired
    private ItemRepository itemRepository;

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Pega todos os favoitos e deixa em formato de lista"))

    @GetMapping("/{id}")
    public FavoritoData GetFavorito (@PathVariable Long id, HttpServletResponse res) {
        if(id != null && favoritoRepo.existsById(id)){
            Favorito c = favoritoRepo.getReferenceById(id);
            FavoritoData cd = new FavoritoData(c);
            return cd;
        }
        res.setStatus(204);
        return null;
    }

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "adiciona um favorito"))

    @PostMapping("/{id}")
    @Transactional
    public void AdicionarFavorito(@PathVariable Long id, @RequestBody FavoritoData data) {
        if (itemRepository.existsById(id)) {
            Favorito c = new Favorito(data);
            favoritoRepo.save(c);
        }
    }

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Deleta um favorito pelo seu id de item"))

    @DeleteMapping("/{id}")
    @Transactional
    public void RemoverFavorito(@PathVariable Long id){
        if(id != null){
            favoritoRepo.deleteById(id);
        }
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Atualiza o item de acordo co o id"))

    @PutMapping("/{id}")
    @Transactional
    public void updateFavorito(@PathVariable Long id, @RequestBody FavoritoData data){
        if(id != null){
            Favorito c = favoritoRepo.getReferenceById(id);
            c.updateFavorito(data);
        }

    }
}





