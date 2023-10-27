package com.fiap.food_techchallenge.application.adapter.inbound.response;

import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

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

    public static PedidoResponse fromDomain(Pedido pedido) {
        return new PedidoResponse(pedido.getId(), UserResponse.fromDomain(pedido.getUser()), pedido.getDatapedido(), pedido.getTotal(), pedido.getOrderStatus());
    }

}
