package com.fiap.food_techchallenge.data.request;

import com.fiap.food_techchallenge.domain.models.CategoriaModel;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaRequest {

    @NotEmpty
    private String descricao;

    public CategoriaModel toCategoriaDomain(){
        return new CategoriaModel(descricao);
    }

    public CategoriaModel toCategoriaDomain(Long id){
        return new CategoriaModel(id, descricao);
    }

}
