package com.fiap.food_techchallenge.application.adapter.inbound.request;

import com.fiap.food_techchallenge.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

    @NotEmpty
    private String descricao;

    public Categoria toCategoriaDomain(){
        return new Categoria(descricao);
    }

    public Categoria toCategoriaDomain(Long id){
        return new Categoria(id, descricao);
    }

}
