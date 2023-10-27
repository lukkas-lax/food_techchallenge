package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.domain.domains.Pedido;

import java.util.List;

public interface PedidoAdapterPort {

    Pedido salvar(Pedido pedido, List<Long> produtos);
//    Pedido listaPedido(Long id);
//    List<PedidoEntity> listaPedidoStatus(String status);
}
