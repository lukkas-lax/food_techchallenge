package com.fiap.food_techchallenge.application.adapter.inbound.request;

import com.fiap.food_techchallenge.domain.domains.Categoria;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.domains.Produto;
import com.fiap.food_techchallenge.domain.domains.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PedidoRequest {

    @NotNull
    private Long userId;

//    @NotEmpty
//    private Date datapedido;

    @NotNull
    private Float total;

    public Pedido toPedidoDomain(){
        return new Pedido(new User(userId), total);
    }


}