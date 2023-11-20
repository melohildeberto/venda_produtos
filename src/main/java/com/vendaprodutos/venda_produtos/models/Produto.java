package com.vendaprodutos.venda_produtos.models;

import java.util.List;

import com.vendaprodutos.venda_produtos.utils.ModelsRegex;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long produtoId;
    @Schema(name = "nome", example = "Café")
    @NotBlank(message = "O nome deverá ser informado")
    @NotNull(message = "Informe o nome")
    @Size(min = 3, max = 60, message = "o nome deverá ter entre 3 e 10 caracteres")
    @Pattern(regexp = ModelsRegex.regex, message = "O nome deverá conter apenas letras")
    @Column(name = "nome", columnDefinition="VARCHAR(40)", nullable = false)
	public String nome;
    @Schema(name = "descricao", example = "Café descafeinado apropriado para a noite")
	@Column(name = "descricao", columnDefinition="VARCHAR(1000)", nullable = false)
	public String descricao;
    @Schema(name = "preco", example = "5.43")
    @Min(value = 1, message = "O valor do produto deverá ser maior que ZERO")
    @Column(name = "preco", columnDefinition="decimal", nullable = false)
	public float preco;
	
    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER)
	List<VendaProduto> vendaProduto;
}
