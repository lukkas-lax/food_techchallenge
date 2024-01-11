package com.fiap.food_techchallenge.data.controllers.request;

import com.fiap.food_techchallenge.domain.models.PedidoModel;
import com.fiap.food_techchallenge.domain.models.UserModel;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PedidoRequest {

    @NotNull
    private Long userId;

    @NotNull
    private List<Long> produtosIds;

    public PedidoModel toPedidoDomain(){
        return new PedidoModel(new UserModel(userId));
    }


}