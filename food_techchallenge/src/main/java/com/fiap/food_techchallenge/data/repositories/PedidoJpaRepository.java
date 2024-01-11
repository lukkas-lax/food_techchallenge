package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByOrderStatus(String orderStatus);
}
