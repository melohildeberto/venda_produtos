package com.vendaprodutos.venda_produtos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.persistence.Id;

@Entity
@Table(name = "vendaproduto")
public class VendaProduto {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long Id;
    @ManyToOne
    @JoinColumn(name = "produtoId")
    Produto produto;
    @ManyToOne
    @JoinColumn(name = "vendaId")
    Venda venda;
    @Min(value = 1, message = "A quantidade deverá ser maior que ZERO")
    @Column(name = "quantidade", columnDefinition = "decimal", nullable = false)
    public float quantidade;
    @Min(value = 1, message = "O preço deverá ser maior que ZERO")
    @Column(name = "preco", columnDefinition = "decimal", nullable = false)
    public float preco;
    @Min(value = 0, message = "O desconto deverá ser maior ou igual a ZERO")
    @Column(name = "desconto", columnDefinition = "decimal", nullable = false)
    public float desconto;
}
