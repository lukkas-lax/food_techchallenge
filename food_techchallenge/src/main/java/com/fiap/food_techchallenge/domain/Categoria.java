package com.fiap.food_techchallenge.domain;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.CategoriaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public static Categoria fromEntity(CategoriaEntity categoriaEntity) {
        return new Categoria(categoriaEntity.getId(), categoriaEntity.getDescricao());
    }
}

