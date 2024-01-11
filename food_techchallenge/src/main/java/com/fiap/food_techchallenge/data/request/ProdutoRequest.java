package com.fiap.food_techchallenge.data.request;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;
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

    public ProdutoModel toProdutoDomain(){
        return new ProdutoModel(nome, descricao, preco, new CategoriaModel(categoriaId));
    }

    public ProdutoModel toProdutoDomain(Long id){
        return new ProdutoModel(id, nome, descricao, preco, new CategoriaModel(categoriaId));
    }

}
