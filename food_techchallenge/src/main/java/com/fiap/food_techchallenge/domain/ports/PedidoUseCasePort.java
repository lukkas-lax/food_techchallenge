package com.fiap.food_techchallenge.domain.ports;

import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.models.PedidoModel;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface PedidoUseCasePort {

//    Pedido executeListar(Long id);
    List<PedidoDTO> executeListarStatus(String status);
    List<PedidoDTO> executeListarTodos();
    PedidoModel executeSalvar(PedidoModel pedidoModel, @NotNull List<Long> produtos);
    PedidoModel executeAtualizar(Long pedidoId);
}
