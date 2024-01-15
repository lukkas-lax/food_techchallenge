package com.fiap.food_techchallenge.data.response;

import com.fiap.food_techchallenge.domain.models.PedidoModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PedidoResponse {
    private Long id;
    private UUID uuid;
    private UserResponse user;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;

    public PedidoResponse(Long id, UUID uuid, UserResponse user, LocalDateTime datapedido, Float total, String orderStatus) {
        this.id = id;
        this.uuid = uuid;
        this.user = user;
        this.datapedido = datapedido;
        this.total = total;
        this.orderStatus = orderStatus;
    }

    public static PedidoResponse fromDomain(PedidoModel pedidoModel) {
        return new PedidoResponse(pedidoModel.getId(), pedidoModel.getUuid(), UserResponse.fromDomain(pedidoModel.getUserModel()), pedidoModel.getDatapedido(), pedidoModel.getTotal(), pedidoModel.getOrderStatus());
    }

}
