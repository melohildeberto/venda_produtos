package com.vendaprodutos.venda_produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendaprodutos.venda_produtos.models.Produto;

public interface RepositorioProduto extends JpaRepository<Produto,Long>{
    
}
