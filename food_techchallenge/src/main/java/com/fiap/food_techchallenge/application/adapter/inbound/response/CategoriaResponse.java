package com.fiap.food_techchallenge.application.adapter.inbound.response;

import com.fiap.food_techchallenge.domain.Categoria;
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

    public static CategoriaResponse fromDomain(Categoria categoria){
        return new CategoriaResponse(categoria.getId(), categoria.getDescricao());
    }
}
