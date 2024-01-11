package com.fiap.food_techchallenge.domain.models;

import com.fiap.food_techchallenge.data.entities.CategoriaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaModel {

    private Long id;
    private String descricao;

    public CategoriaModel(Long id) {
        this.id = id;
        this.descricao = "";
    }

    public CategoriaModel(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public CategoriaModel(String descricao) {
        this.descricao = descricao;
    }

    public static CategoriaModel fromEntity(CategoriaEntity categoriaEntity) {
        return new CategoriaModel(categoriaEntity.getId(), categoriaEntity.getDescricao());
    }
}

