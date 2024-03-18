package com.lampi.deposit.model;

//record é uma classe mais "limpa"(UM DTO)
///passei os parametros e criei um enum de <cor>
public record DadosCadastrosItens(
    String nome,
    String capa,
    int preco,
    Cor cor){

}
