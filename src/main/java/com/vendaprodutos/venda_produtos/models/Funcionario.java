package com.vendaprodutos.venda_produtos.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionarioId")
	public Long funcionarioId;
    @JsonIgnoreProperties(value = {"venda"}, allowSetters=true)
	@OneToMany(mappedBy="funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Venda> vendas;
}
