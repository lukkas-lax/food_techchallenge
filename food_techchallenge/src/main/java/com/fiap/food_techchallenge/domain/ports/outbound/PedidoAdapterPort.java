package com.fiap.food_techchallenge.domain.ports.outbound;

import com.fiap.food_techchallenge.application.adapter.outbound.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PedidoAdapterPort {

    Pedido salvar(Pedido pedido, List<Long> produtos);
//    Pedido listaPedido(Long id);
    List<PedidoDTO> listaPedidoStatus(String status);

    @Transactional
    Pedido atualizaStatus(Long pedidoId);

    List<PedidoDTO> listaPedidos();

    PedidoDTO buscaStatusPagamento(Long pedidoId);

}
