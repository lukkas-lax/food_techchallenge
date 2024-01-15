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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        pedidoEntity.setPaymentStatus("APROVADO");
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
                        pedido.getTotal(), pedido.getOrderStatus(), produtosResult, "APROVADO"));
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

    @Override
    public List<PedidoDTO> listaPedidos() {
        var pedidosList = pedidoRepository.findAll();
        var pedidosOrdenados = pedidosList.stream().sorted(Comparator.comparing(PedidoEntity::getOrderStatus, Comparator.comparingInt(status -> {
            switch (status) {
                case "READY":
                    return 1;
                case "IN_PREPARATION":
                    return 2;
                case "RECEIVED":
                    return 3;
                default:
                    return 4;
            }
        })).thenComparing(PedidoEntity::getDatapedido, Comparator.reverseOrder())).toList();


        List<PedidoDTO> listaPedidos = pedidosOrdenados.stream().map(pedidoEntity -> {
            List<Produto> produtosResult = new ArrayList<>();
            List<ItensPedidoEntity> itensProduto = itensPedidoRepository.findAllByPedidoEntity(pedidoEntity);
            for (ItensPedidoEntity item : itensProduto){
                produtosResult.add(Produto.fromEntity(item.getProdutoEntity()));
            }

            PedidoDTO dto = new PedidoDTO();
            dto.setDatapedido(pedidoEntity.getDatapedido());
            dto.setUser(User.fromEntity(pedidoEntity.getUserEntity()));
            dto.setTotal(pedidoEntity.getTotal());
            dto.setId(pedidoEntity.getId());
            dto.setOrderStatus(pedidoEntity.getOrderStatus());
            dto.setPaymentStatus(pedidoEntity.getPaymentStatus());
            dto.setProdutos(produtosResult);
            return dto;
        }).toList();




        return listaPedidos;
    }

    @Override
    public PedidoDTO buscaStatusPagamento(Long pedidoId) {
        var p = pedidoRepository.findById(pedidoId);
        PedidoDTO p2 = new PedidoDTO();
        p2.setPaymentStatus(p.get().getPaymentStatus());
        p2.setUser(User.fromEntity(p.get().getUserEntity()));
        p2.setTotal(p.get().getTotal());
        p2.setId(p.get().getId());
        p2.setDatapedido(p.get().getDatapedido());

        List<ItensPedidoEntity> itensProduto = itensPedidoRepository.findAllByPedidoEntity(p.get());
        List<Produto> produtosResult = new ArrayList<>();
        for (ItensPedidoEntity item : itensProduto){
            produtosResult.add(Produto.fromEntity(item.getProdutoEntity()));
        }
        p2.setProdutos(produtosResult);
        p2.setOrderStatus(p.get().getOrderStatus());
        return p2;
    }


}
