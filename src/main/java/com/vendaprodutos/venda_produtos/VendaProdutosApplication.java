package com.vendaprodutos.venda_produtos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vendaprodutos.venda_produtos.repositories.RepositorioCliente;
import com.vendaprodutos.venda_produtos.repositories.RepositorioFuncionario;

@SpringBootApplication
public class VendaProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaProdutosApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(RepositorioCliente repositorioCliente , RepositorioFuncionario repositorioFuncionario) throws Exception {
		return args -> {
			
		};
	}

}
