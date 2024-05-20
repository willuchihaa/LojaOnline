package com.lampi.deposit.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lampi.deposit.model.carrinho.Carrinho;
import com.lampi.deposit.model.carrinho.CarrinhoData;
import com.lampi.deposit.model.carrinho.CarrinhoDataResumo;
import com.lampi.deposit.model.item.ItensData;
import com.lampi.deposit.repository.carrinho.CarrinhoRepository;
import com.lampi.deposit.repository.itens.ItemRepository;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

@RestController // pra dizer q é um controller
@RequestMapping("/carrinho") // negocio que fica na url
public class CarrinhoController {

    @Autowired //serve pra botar autoamticamente as dependencias
    private CarrinhoRepository carrinhoRepo;
    @Autowired // sla pra que
    private ItemRepository itemRepository;

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Pega todos os iten e deixa em formato de lista "))
    @GetMapping // metodo get 
    public List<CarrinhoDataResumo> PegarTodosItens(){
        return carrinhoRepo.findAll().stream().map(CarrinhoDataResumo::new).toList();
    } //convetrte todo o get e o construtor, pra uma lista

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "pega um item de acordo com seu id "))
    @GetMapping("/{id}") // metodo get com parametro de id
    public CarrinhoData PegarOItem(@PathVariable Long id, HttpServletResponse res) {
        if(id != null && itemRepository.existsById(id)){
            Carrinho d = carrinhoRepo.getReferenceById(id);
            CarrinhoData de = new CarrinhoData(d);
            return de;
        }
        res.setStatus(204);
        return null;
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "salva o item no banco de dados do carrinho "))
    @PostMapping("/{id}")// metodo post
    @Transactional // serve para a transacao com o DATABASE
    public void salvaItem(@PathVariable Long id, @RequestBody CarrinhoData data) {
        if (itemRepository.existsById(id)) {
            Carrinho c = new Carrinho(data);
            carrinhoRepo.save(c);
            
        /*Carrinho carrinhoCalcularTotal = new Carrinho();// pela logica eu criei um novo
            carrinhoCalcularTotal.calcularTotal(null);
            System.out.println(carrinhoCalcularTotal);   */
        }
    }

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Deleta o item de acordo com o id selecionado"))
    @DeleteMapping("/{id}") // metodo delete com id de parametro
    @Transactional
    public void deletarItem(@PathVariable Long id){
        if(id != null){
            carrinhoRepo.deleteById(id);
        }
    }
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "Atualiza o item de acordo com o id caso tenha modificado ele "))
    @PutMapping("/{id}")
    @Transactional
    public void atualizarItem(@PathVariable Long id, @RequestBody CarrinhoData dados){
        if(id != null){
            Carrinho c = carrinhoRepo.getReferenceById(id);
            c.updatee(dados);
        }
    }
    
 }

 /*
  * RequestBody e o corpo da requisicao
  pathvariable serve pra metodos com parametros
  */