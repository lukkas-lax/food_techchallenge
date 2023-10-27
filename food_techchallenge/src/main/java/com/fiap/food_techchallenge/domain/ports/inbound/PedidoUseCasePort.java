package com.fiap.food_techchallenge.domain.ports.inbound;

import com.fiap.food_techchallenge.application.adapter.outbound.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface PedidoUseCasePort {

//    Pedido executeListar(Long id);
    List<PedidoDTO> executeListarStatus(String status);
    Pedido executeSalvar(Pedido pedido, @NotNull List<Long> produtos);

    Pedido executeAtualizar(Long pedidoId);
}
