package com.fiap.food_techchallenge.application.adapter.inbound.request;

import com.fiap.food_techchallenge.domain.domains.Categoria;
import com.fiap.food_techchallenge.domain.domains.Produto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequest {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String descricao;

    @NotNull
    private Float preco;

    @NotNull
    private Long categoriaId;

    public Produto toProdutoDomain(){
        return new Produto(nome, descricao, preco, new Categoria(categoriaId));
    }

    public Produto toProdutoDomain(Long id){
        return new Produto(id, nome, descricao, preco, new Categoria(categoriaId));
    }

}
