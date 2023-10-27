package com.fiap.food_techchallenge.domain.domains;


import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
public class Pedido {

    private Long id;
    private User user;
    private LocalDateTime datapedido;
    private Float total;
    private String orderStatus;

    public Pedido(User user) {
        this.user = user;
    }

    public static Pedido fromEntity(PedidoEntity pedidoEntity) {
        return new Pedido(pedidoEntity.getId(),
                User.fromEntity(pedidoEntity.getUserEntity()),
                pedidoEntity.getDatapedido(),
                pedidoEntity.getTotal(),
                pedidoEntity.getOrderStatus());
    }

    public Pedido(Long id, User user, LocalDateTime datapedido, Float total) {
        this.id = id;
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
    }

    public Pedido(User user, LocalDateTime datapedido, Float total) {
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
    }

    public Pedido(Long id, User user, LocalDateTime datapedido, Float total, String orderStatus) {
        this.id = id;
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
        this.orderStatus = orderStatus;
    }

    public Pedido(User user, LocalDateTime datapedido, Float total, String orderStatus) {
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
        this.orderStatus = orderStatus;
    }
}


