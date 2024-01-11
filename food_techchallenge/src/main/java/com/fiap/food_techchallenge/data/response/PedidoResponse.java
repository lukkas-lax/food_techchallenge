package com.fiap.food_techchallenge.data.response;

import com.fiap.food_techchallenge.domain.models.PedidoModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private UserResponse user;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;

    public PedidoResponse(Long id, UserResponse user, LocalDateTime datapedido, Float total, String orderStatus) {
        this.id = id;
        this.user = user;
        this.datapedido = datapedido;
        this.total = total;
        this.orderStatus = orderStatus;
    }

    public static PedidoResponse fromDomain(PedidoModel pedidoModel) {
        return new PedidoResponse(pedidoModel.getId(), UserResponse.fromDomain(pedidoModel.getUserModel()), pedidoModel.getDatapedido(), pedidoModel.getTotal(), pedidoModel.getOrderStatus());
    }

}
