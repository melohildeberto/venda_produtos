package com.vendaprodutos.venda_produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendaprodutos.venda_produtos.models.Funcionario;

public interface RepositorioFuncionario extends JpaRepository<Funcionario,Long>{

    
} 
