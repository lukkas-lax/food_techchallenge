package com.fiap.food_techchallenge.domain.usecase;

import com.fiap.food_techchallenge.application.adapter.outbound.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.domains.Produto;
import com.fiap.food_techchallenge.domain.ports.inbound.PedidoUseCasePort;
import com.fiap.food_techchallenge.domain.ports.outbound.PedidoAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.ProdutoAdapterPort;
import com.fiap.food_techchallenge.domain.ports.outbound.UserAdapterPort;

import java.util.List;

public class PedidoUseCase implements PedidoUseCasePort {

    private final PedidoAdapterPort pedidoAdapterPort;
    private final UserAdapterPort userAdapterPort;

    private final ProdutoAdapterPort produtoAdapterPort;

    public PedidoUseCase(PedidoAdapterPort pedidoAdapterPort, UserAdapterPort userAdapterPort, ProdutoAdapterPort produtoAdapterPort) {
        this.pedidoAdapterPort = pedidoAdapterPort;
        this.userAdapterPort = userAdapterPort;
        this.produtoAdapterPort = produtoAdapterPort;
    }

    @Override
    public Pedido executeSalvar(Pedido pedido, List<Long> produtos) {
        pedido.setUser(userAdapterPort.listaUsuario(pedido.getUser().getId()));
        float totalPedido = 00.00F;
        for (Long produto : produtos) {
            Produto produtoRetorno = produtoAdapterPort.listaProduto(produto);
            totalPedido = totalPedido+produtoRetorno.getPreco();
        }
        pedido.setTotal(totalPedido);

        return pedidoAdapterPort.salvar(pedido, produtos);
    }

//    @Override
//    public Pedido executeListar(Long id) {
//        Pedido pedido = pedidoAdapterPort.listaPedido(id);
//        pedido.setUser(userAdapterPort.listaUsuario(pedido.getUser().getId()));
//        return pedido;
//    }
//
    @Override
    public List<PedidoDTO> executeListarStatus(String status) {
        return pedidoAdapterPort.listaPedidoStatus(status);
    }

    @Override
    public Pedido executeAtualizar(Long pedidoId) {
        return pedidoAdapterPort.atualizaStatus(pedidoId);
    }

    @Override
    public List<PedidoDTO> listarPedidos() {
        return pedidoAdapterPort.listaPedidos();
    }

    @Override
    public PedidoDTO buscaStatusPagamento(Long pedidoId) {
        return pedidoAdapterPort.buscaStatusPagamento(pedidoId);
    }

}
