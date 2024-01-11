package com.fiap.food_techchallenge.domain.models;



import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProdutoModel {

    private Long id;
    private String nome;
    private String descricao;
    private Float preco;
    private CategoriaModel categoriaModel;

    public static ProdutoModel fromEntity(ProdutoEntity produtoEntity) {
        return new ProdutoModel(produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getPreco(),
                new CategoriaModel(produtoEntity.getCategoriaId()));
    }


    public ProdutoModel(Long id, String nome, String descricao, Float preco, CategoriaModel categoriaModel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco == null ? (float) 0.0 : preco;
        this.categoriaModel = categoriaModel;
    }

    public ProdutoModel(String nome, String descricao, Float preco, CategoriaModel categoriaModel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco == null ? (float) 0 : preco;
        this.categoriaModel = categoriaModel;
    }
}

