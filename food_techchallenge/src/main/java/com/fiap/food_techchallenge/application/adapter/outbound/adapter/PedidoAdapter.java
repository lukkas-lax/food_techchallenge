package com.fiap.food_techchallenge.application.adapter.outbound.adapter;

import com.fiap.food_techchallenge.application.adapter.outbound.dto.PedidoDTO;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.ItensPedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.UserEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.ItensPedidoRepository;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.PedidoRepository;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.ProdutoRepository;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.domains.Produto;
import com.fiap.food_techchallenge.domain.domains.User;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import com.fiap.food_techchallenge.domain.ports.outbound.PedidoAdapterPort;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PedidoAdapter implements PedidoAdapterPort {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ItensPedidoRepository itensPedidoRepository;

    public PedidoAdapter(PedidoRepository pedidoRepository,
                         ProdutoRepository produtoRepository, ItensPedidoRepository itensPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.itensPedidoRepository = itensPedidoRepository;
    }

    @Override
    @Transactional
    public Pedido salvar(Pedido pedido, List<Long> produtos) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setUserEntity(new UserEntity(pedido.getUser().getId(), pedido.getUser().getNome(), pedido.getUser().getCpf(), pedido.getUser().getEmail()));
        pedidoEntity.setDatapedido(LocalDateTime.now());
        pedidoEntity.setTotal(pedido.getTotal());
        pedidoEntity.setOrderStatus(OrderStatus.RECEIVED.name());
        var pedidoRetorno = pedidoRepository.save(pedidoEntity);
        pedido.setId(pedidoRetorno.getId());
        pedido.setDatapedido(pedidoRetorno.getDatapedido());
        pedido.setOrderStatus(pedidoRetorno.getOrderStatus());
        for (Long produto : produtos) {
            Optional<ProdutoEntity> produtoRetorno = produtoRepository.findById(produto);
            if(produtoRetorno.isPresent()){
                itensPedidoRepository.save(new ItensPedidoEntity(produtoRetorno.get(), pedidoRetorno));
            }
            else{
                throw new NoResultException();
            }
        }
        return pedido;
    }

    @Override
    public List<PedidoDTO> listaPedidoStatus(String status) {
        try{
            List<PedidoDTO> pedidosResult = new ArrayList<>();
            var pedidos = pedidoRepository.findAllByOrderStatus(status);
            for (PedidoEntity pedido : pedidos) {
                List<Produto> produtosResult = new ArrayList<>();
                List<ItensPedidoEntity> itensProduto = itensPedidoRepository.findAllByPedidoEntity(pedido);
                for (ItensPedidoEntity item : itensProduto){
                    produtosResult.add(Produto.fromEntity(item.getProdutoEntity()));
                }
                pedidosResult.add(new PedidoDTO(pedido.getId(), User.fromEntity(pedido.getUserEntity()), pedido.getDatapedido(),
                        pedido.getTotal(), pedido.getOrderStatus(), produtosResult));
            }
            return pedidosResult;
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @Override
    @Transactional
    public Pedido atualizaStatus(Long pedidoId) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoId).get();
        if(pedidoEntity.getOrderStatus().equals("RECEIVED")){
            pedidoEntity.setOrderStatus(OrderStatus.IN_PREPARATION.name());
            return Pedido.fromEntity(pedidoRepository.save(pedidoEntity));
        }
        if(pedidoEntity.getOrderStatus().equals("IN_PREPARATION")){
            pedidoEntity.setOrderStatus(OrderStatus.READY.name());
            return Pedido.fromEntity(pedidoRepository.save(pedidoEntity));
        }
        if(pedidoEntity.getOrderStatus().equals("READY")){
            pedidoEntity.setOrderStatus(OrderStatus.COMPLETED.name());
            return Pedido.fromEntity(pedidoRepository.save(pedidoEntity));
        }

        return Pedido.fromEntity(pedidoRepository.save(pedidoEntity));
    }


}
