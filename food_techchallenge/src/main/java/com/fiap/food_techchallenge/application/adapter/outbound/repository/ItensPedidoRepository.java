package com.fiap.food_techchallenge.application.adapter.outbound.repository;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.ItensPedidoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensPedidoRepository extends JpaRepository<ItensPedidoEntity, Long> {
    List<ItensPedidoEntity> findAllByPedidoEntity(PedidoEntity pedidoEntity);
}
