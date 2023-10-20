package com.fiap.food_techchallenge.domain;



import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

