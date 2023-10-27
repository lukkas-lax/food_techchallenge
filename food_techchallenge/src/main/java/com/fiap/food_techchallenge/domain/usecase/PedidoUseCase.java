package com.fiap.food_techchallenge.domain.usecase;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.ports.inbound.PedidoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.PedidoAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;

import java.util.List;

public class PedidoUseCase implements PedidoUseCasePort {

    private final PedidoAdapterPort pedidoAdapterPort;
    private final UserAdapterPort userAdapterPort;

    public PedidoUseCase(PedidoAdapterPort pedidoAdapterPort, UserAdapterPort userAdapterPort) {
        this.pedidoAdapterPort = pedidoAdapterPort;
        this.userAdapterPort = userAdapterPort;
    }

    @Override
    public Pedido executeSalvar(Pedido pedido) {
        pedido.setUser(userAdapterPort.listaUsuario(pedido.getUser().getId()));
        return pedidoAdapterPort.salvar(pedido);
    }

//    @Override
//    public Pedido executeListar(Long id) {
//        Pedido pedido = pedidoAdapterPort.listaPedido(id);
//        pedido.setUser(userAdapterPort.listaUsuario(pedido.getUser().getId()));
//        return pedido;
//    }
//
//    @Override
//    public List<PedidoEntity> executeListarStatus(String status) {
//        return pedidoAdapterPort.listaPedidoStatus(status);
//    }

}
