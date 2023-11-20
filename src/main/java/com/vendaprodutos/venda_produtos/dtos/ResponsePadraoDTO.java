package com.vendaprodutos.venda_produtos.dtos;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;

public class ResponsePadraoDTO {
    public int statusCode;
    public String mensagem;
    public ArrayList<String> erros;
    public ResponsePadraoDTO(){
        this.erros = new ArrayList<>();
        this.mensagem = "OK";
        this.statusCode = HttpStatus.OK.value();
    }
}
