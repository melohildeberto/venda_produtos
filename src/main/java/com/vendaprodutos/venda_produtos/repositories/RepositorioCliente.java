package com.vendaprodutos.venda_produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendaprodutos.venda_produtos.models.Cliente;

public interface RepositorioCliente extends JpaRepository<Cliente,Long>{
    
}
