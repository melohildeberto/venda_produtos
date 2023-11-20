package com.vendaprodutos.venda_produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendaprodutos.venda_produtos.models.VendaProduto;

public interface RepositorioVendaProduto extends JpaRepository<VendaProduto,Long> {
    
}