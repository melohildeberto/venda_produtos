package com.vendaprodutos.venda_produtos.dtos;

import java.util.ArrayList;
import java.util.List;

import com.vendaprodutos.venda_produtos.models.Produto;

public class ResponseProdutoListar extends ResponsePadraoDTO{
    public List<Produto> produtos;
    public int quantidade;
    public ResponseProdutoListar(){
        super();
        this.produtos = new ArrayList<>();
        this.quantidade = 0;
    }
}
