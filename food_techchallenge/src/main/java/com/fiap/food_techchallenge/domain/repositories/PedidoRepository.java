package com.fiap.food_techchallenge.domain.repositories;

import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.models.PedidoModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PedidoRepository {

    PedidoModel salvar(PedidoModel pedidoModel, List<Long> produtos);
//    Pedido listaPedido(Long id);
    List<PedidoDTO> listaPedidoStatus(String status);
    List<PedidoDTO> listaPedidos();
    @Transactional
    PedidoModel atualizaStatus(Long pedidoId);

    PedidoDTO buscaStatusPagamento (Long pedidoId);

}
