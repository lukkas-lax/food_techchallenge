package com.fiap.food_techchallenge.domain.domains;



import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Float preco;
    private Categoria categoria;

    public static Produto fromEntity(ProdutoEntity produtoEntity) {
        return new Produto(produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getPreco(),
                new Categoria(produtoEntity.getCategoriaId()));
    }


    public Produto(Long id, String nome, String descricao, Float preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco == null ? (float) 0.0 : preco;
        this.categoria = categoria;
    }

    public Produto(String nome, String descricao, Float preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco == null ? (float) 0 : preco;
        this.categoria = categoria;
    }
}

