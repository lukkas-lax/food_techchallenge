package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface PedidoUseCasePort {

//    Pedido executeListar(Long id);
    List<PedidoEntity> executeListarStatus(String status);
    Pedido executeSalvar(Pedido pedido, @NotNull List<Long> produtos);
}
