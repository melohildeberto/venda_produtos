package com.vendaprodutos.venda_produtos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendaprodutos.venda_produtos.dtos.ResponsePadraoDTO;
import com.vendaprodutos.venda_produtos.dtos.ResponseProdutoListar;
import com.vendaprodutos.venda_produtos.models.Produto;
import com.vendaprodutos.venda_produtos.repositories.RepositorioProduto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ControladorProduto {
    @Autowired
    RepositorioProduto repositorioProduto;

    @Parameters({
            @Parameter(name = "Nome", description = "Nome do produtos", required = true, example = "Café"),
            @Parameter(name = "Descrição", description = "Descrição detalhada do produto", required = true, example = "Café gostoso"),
            @Parameter(name = "Preço", description = "Preço do produto", required = true, example = "5.63"),
    })
    @Operation(summary = "Cadastra um novo Produto", description = "<h1>Cria um novo produto no banco de dados e retorna uma mensagem.</h1>", tags = {
            "Post" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = ResponsePadraoDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Validação de dados", content = {
                    @Content(schema = @Schema()) }),
    })
    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity<ResponsePadraoDTO> cadastrar(@RequestBody @Valid Produto produto,
            BindingResult bindingResult) {
        ResponsePadraoDTO resposta = new ResponsePadraoDTO();
        resposta.mensagem = "Produto cadastrado";
        resposta.statusCode = 201;
        if (bindingResult.hasErrors()) {
            resposta.mensagem = "Não foi possível cadastrar o Aluno";
            for (ObjectError obj : bindingResult.getAllErrors()) {
                resposta.erros.add(obj.getDefaultMessage());
            }
            resposta.statusCode = 400;
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        repositorioProduto.save(produto);
        return new ResponseEntity<>(resposta, HttpStatus.CREATED);
    }

    @Operation(summary = "Retorna os produtos", description = "<h1>Retorna os produtos cadastrados no banco de dados .</h1>", tags = {
            "Post" })
    @ApiResponses({
            @ApiResponse(responseCode = "202", content = {
                    @Content(schema = @Schema(implementation = ResponseProdutoListar.class), mediaType = "application/json") }),
    })
    @GetMapping("/listar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ResponseProdutoListar> listar() {
        ResponseProdutoListar resposta = new ResponseProdutoListar();
        List<Produto> lista = repositorioProduto.findAll();
        resposta.quantidade = lista.size();
        resposta.produtos = lista;
        if (lista.size() == 0) {
            resposta.mensagem = "Listagem sem resultados";
        }
        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }
}
