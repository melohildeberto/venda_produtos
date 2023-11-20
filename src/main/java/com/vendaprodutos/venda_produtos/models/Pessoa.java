package com.vendaprodutos.venda_produtos.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Pessoa {
    @NotBlank(message = "O nome deverá ser informado")
    @NotNull(message = "Informe o nome")
    @Size(min = 3, max = 60, message = "o nome deverá ter entre 3 e 10 caracteres")
    @Pattern(regexp = "^[a-zA-Z/s]{3,60}$", message = "O nome deverá conter apenas letras")
	@Column(name = "nome", columnDefinition="VARCHAR(60)", nullable = false)
	public String nome;
	@Pattern(regexp = "^[0-9]{11}$", message = "O CPF deverá ser numérico e ter 11 digitos")
	@Column(name = "cpf", columnDefinition="VARCHAR(11)", unique = true, nullable = false)
	public String cpf;
	@Max(value = 11, message = "O RG deverá ter no máximo 10 digitos")
    @Pattern(regexp = "^[0-9]$", message = "O RG deverá ser numérico")
	@Column(name = "rg", columnDefinition="VARCHAR(10)", nullable = false)
	public String rg;
	
}
