package com.fiap.food_techchallenge.application.adapter.outbound.adapter;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.UserEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.repository.PedidoRepository;
import com.fiap.food_techchallenge.domain.domains.Pedido;
import com.fiap.food_techchallenge.domain.enums.OrderStatus;
import com.fiap.food_techchallenge.domain.ports.outbound.PedidoAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class PedidoAdapter implements PedidoAdapterPort {

    private final PedidoRepository pedidoRepository;

    public PedidoAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    @Transactional
    public Pedido salvar(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setUserEntity(new UserEntity(pedido.getUser().getId(), pedido.getUser().getNome(), pedido.getUser().getCpf(), pedido.getUser().getEmail()));
        pedidoEntity.setDatapedido(LocalDateTime.now());
        pedidoEntity.setTotal(pedido.getTotal());
        pedidoEntity.setOrderStatus(OrderStatus.RECEIVED.name());
        var pedidoRetorno = pedidoRepository.save(pedidoEntity);
        pedido.setId(pedidoRetorno.getId());
        pedido.setDatapedido(pedidoRetorno.getDatapedido());
        pedido.setOrderStatus(pedidoRetorno.getOrderStatus());
        return pedido;
    }

//    @Override
//    public Pedido listaPedido(Long id) {
//        try{
//            var pedido = pedidoRepository.findById(id);
//            return Pedido.fromEntity(pedido.get());
//        } catch (Exception e) {
//            throw new EntityNotFoundException();
//        }
//
//    }
//
//    @Override
//    public List<PedidoEntity> listaPedidoStatus(String status) {
//        try{
//            return pedidoRepository.findAllByStatus(status);
//        } catch (Exception e) {
//            throw new EntityNotFoundException();
//        }
//    }
}
