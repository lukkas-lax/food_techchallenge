package com.fiap.food_techchallenge.domain.usecases;

import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.domain.models.PedidoModel;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.ports.PedidoUseCasePort;
import com.fiap.food_techchallenge.domain.repositories.PedidoRepository;
import com.fiap.food_techchallenge.domain.repositories.ProdutoRepository;
import com.fiap.food_techchallenge.domain.repositories.UserRepository;

import java.util.List;
import java.util.UUID;

public class PedidoUseCase implements PedidoUseCasePort {

    private final PedidoRepository pedidoRepository;
    private final UserRepository userRepository;

    private final ProdutoRepository produtoRepository;

    public PedidoUseCase(PedidoRepository pedidoRepository, UserRepository userRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.userRepository = userRepository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public PedidoModel executeSalvar(PedidoModel pedidoModel, List<Long> produtos) {
        pedidoModel.setUserModel(userRepository.listaUsuario(pedidoModel.getUserModel().getId()));
        float totalPedido = 00.00F;
        UUID uuid = UUID.randomUUID();
        String uuidFinal = uuid.toString();
        for (Long produto : produtos) {
            ProdutoModel produtoModelRetorno = produtoRepository.listaProduto(produto);
            totalPedido = totalPedido+ produtoModelRetorno.getPreco();
        }
        pedidoModel.setUuid(uuidFinal);
        pedidoModel.setTotal(totalPedido);

        return pedidoRepository.salvar(pedidoModel, produtos);
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
        return pedidoRepository.listaPedidoStatus(status);
    }

    @Override
    public List<PedidoDTO> executeListarTodos() {
        return pedidoRepository.listaPedidos();
    }

    @Override
    public PedidoModel executeAtualizar(Long pedidoId) {
        return pedidoRepository.atualizaStatus(pedidoId);
    }

    @Override
    public PedidoDTO buscaStatusPagamento(Long pedidoId) {
        return pedidoRepository.buscaStatusPagamento(pedidoId);
    }

}
