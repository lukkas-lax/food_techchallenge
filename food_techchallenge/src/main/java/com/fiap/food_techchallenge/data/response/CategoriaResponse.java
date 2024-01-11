package com.fiap.food_techchallenge.data.response;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponse {

    private Long id;

    private String descricao;

    public CategoriaResponse(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static CategoriaResponse fromDomain(CategoriaModel categoriaModel){
        return new CategoriaResponse(categoriaModel.getId(), categoriaModel.getDescricao());
    }
}
