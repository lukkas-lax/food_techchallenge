package com.fiap.food_techchallenge.domain.domains;


import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Pedido {

    private Long id;
    private User user;
    private Date datapedido;
    private Float total;
    private OrderStatus orderStatus;

    public static Pedido fromEntity(PedidoEntity pedidoEntity) {
        return new Pedido(pedidoEntity.getId(),
                User.fromEntity(pedidoEntity.getUserEntity()),
                pedidoEntity.getDatapedido(),
                pedidoEntity.getTotal(),
                pedidoEntity.getOrderStatus());
    }


    public Pedido(Long id, User user, Date datapedido, Float total, OrderStatus orderStatus) {
        this.id = id;
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
        this.orderStatus = orderStatus;
    }

    public Pedido(User user, Date datapedido, Float total, OrderStatus orderStatus) {
        this.user = user;
        this.datapedido = datapedido;
        this.total = total == null ? (float) 0.0 : total;
        this.orderStatus = orderStatus;
    }
}


