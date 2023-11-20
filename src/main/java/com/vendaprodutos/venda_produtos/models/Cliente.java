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
@Table(name = "cliente")
public class Cliente extends Pessoa{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clienteId")
	public Long clienteId;
    @JsonIgnoreProperties(value = {"venda"}, allowSetters=true)
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Venda> vendas;
}
