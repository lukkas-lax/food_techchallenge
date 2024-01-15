package com.fiap.food_techchallenge.data.adapter;

import com.fiap.food_techchallenge.data.dto.PedidoDTO;
import com.fiap.food_techchallenge.data.entities.ItensPedidoEntity;
import com.fiap.food_techchallenge.data.entities.PedidoEntity;
import com.fiap.food_techchallenge.data.entities.ProdutoEntity;
import com.fiap.food_techchallenge.data.entities.UserEntity;
import com.fiap.food_techchallenge.data.repositories.ItensPedidoJpaRepository;
import com.fiap.food_techchallenge.data.repositories.PedidoJpaRepository;
import com.fiap.food_techchallenge.data.repositories.ProdutoJpaRepository;
import com.fiap.food_techchallenge.domain.models.PedidoModel;
import com.fiap.food_techchallenge.domain.models.ProdutoModel;
import com.fiap.food_techchallenge.domain.models.UserModel;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import com.fiap.food_techchallenge.domain.repositories.PedidoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PedidoAdapter implements PedidoRepository {

    private final PedidoJpaRepository pedidoRepository;
    private final ProdutoJpaRepository produtoJpaRepository;
    private final ItensPedidoJpaRepository itensPedidoJpaRepository;

    public PedidoAdapter(PedidoJpaRepository pedidoRepository,
                         ProdutoJpaRepository produtoJpaRepository, ItensPedidoJpaRepository itensPedidoJpaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoJpaRepository = produtoJpaRepository;
        this.itensPedidoJpaRepository = itensPedidoJpaRepository;
    }

    @Override
    @Transactional
    public PedidoModel salvar(PedidoModel pedidoModel, List<Long> produtos) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setUserEntity(new UserEntity(pedidoModel.getUserModel().getId(), pedidoModel.getUserModel().getNome(), pedidoModel.getUserModel().getCpf(), pedidoModel.getUserModel().getEmail()));
        pedidoEntity.setDatapedido(LocalDateTime.now());
        pedidoEntity.setTotal(pedidoModel.getTotal());
        pedidoEntity.setOrderStatus(OrderStatus.RECEIVED.name());
        pedidoEntity.setUuid(pedidoModel.getUuid());
        var pedidoRetorno = pedidoRepository.save(pedidoEntity);
        pedidoModel.setId(pedidoRetorno.getId());
        pedidoModel.setDatapedido(pedidoRetorno.getDatapedido());
        pedidoModel.setOrderStatus(pedidoRetorno.getOrderStatus());
        for (Long produto : produtos) {
            Optional<ProdutoEntity> produtoRetorno = produtoJpaRepository.findById(produto);
            if(produtoRetorno.isPresent()){
                itensPedidoJpaRepository.save(new ItensPedidoEntity(produtoRetorno.get(), pedidoRetorno));
            }
            else{
                throw new NoResultException();
            }
        }
        return pedidoModel;
    }

    @Override
    public List<PedidoDTO> listaPedidoStatus(String status) {
        try{
            List<PedidoDTO> pedidosResult = new ArrayList<>();
            var pedidos = pedidoRepository.findAllByOrderStatus(status);
            for (PedidoEntity pedido : pedidos) {
                List<ProdutoModel> produtosResult = new ArrayList<>();
                List<ItensPedidoEntity> itensProduto = itensPedidoJpaRepository.findAllByPedidoEntity(pedido);
                for (ItensPedidoEntity item : itensProduto){
                    produtosResult.add(ProdutoModel.fromEntity(item.getProdutoEntity()));
                }
                pedidosResult.add(new PedidoDTO(pedido.getId(), pedido.getUuid(), UserModel.fromEntity(pedido.getUserEntity()), pedido.getDatapedido(),
                        pedido.getTotal(), pedido.getOrderStatus(), produtosResult));
            }
            return pedidosResult;
        } catch (Exception e) {
            throw new NoResultException();
        }
    }

    @Override
    @Transactional
    public PedidoModel atualizaStatus(Long pedidoId) {
        PedidoEntity pedidoEntity = pedidoRepository.findById(pedidoId).get();
        if(pedidoEntity.getOrderStatus().equals("RECEIVED")){
            pedidoEntity.setOrderStatus(OrderStatus.IN_PREPARATION.name());
            return PedidoModel.fromEntity(pedidoRepository.save(pedidoEntity));
        }
        if(pedidoEntity.getOrderStatus().equals("IN_PREPARATION")){
            pedidoEntity.setOrderStatus(OrderStatus.READY.name());
            return PedidoModel.fromEntity(pedidoRepository.save(pedidoEntity));
        }
        if(pedidoEntity.getOrderStatus().equals("READY")){
            pedidoEntity.setOrderStatus(OrderStatus.COMPLETED.name());
            return PedidoModel.fromEntity(pedidoRepository.save(pedidoEntity));
        }

        return PedidoModel.fromEntity(pedidoRepository.save(pedidoEntity));
    }


}
