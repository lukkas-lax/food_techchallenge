package com.fiap.food_techchallenge.domain;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.CategoriaEntity;

public class Categoria {

    private Long id;
    private String descricao;

    public Categoria(Long id) {
        this.id = id;
        this.descricao = "";
    }

    public Categoria(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static Categoria fromEntity(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getDescricao());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

