package com.fiap.food_techchallenge.application.adapter.inbound.response;

import com.fiap.food_techchallenge.domain.domains.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Float preco;
    private CategoriaResponse categoria;

    public ProdutoResponse(Long id, String nome, String descricao, Float preco, CategoriaResponse categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(Produto produto){
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), CategoriaResponse.fromDomain(produto.getCategoria()));
    }

}
