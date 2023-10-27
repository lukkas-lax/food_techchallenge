package com.fiap.food_techchallenge.application.adapter.outbound.repository;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByOrderStatus(String orderStatus);
}
