package com.vendaprodutos.venda_produtos.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendaId")
	public Long vendaId;
	@Column(name = "numero", columnDefinition="VARCHAR(60)", nullable = false)
	public String numero;
	
	@ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    public Cliente cliente;
	@ManyToOne
    @JoinColumn(name="funcionario_id", nullable=false)
	@JsonIgnoreProperties(value = {"vendas"}, allowSetters = true)
    public Funcionario funcionario;

    @OneToMany(mappedBy = "venda", fetch = FetchType.EAGER)
	List<VendaProduto> vendaProduto;
}
