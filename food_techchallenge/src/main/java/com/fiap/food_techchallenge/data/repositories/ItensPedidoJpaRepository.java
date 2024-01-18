package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.ItensPedidoEntity;
import com.fiap.food_techchallenge.data.entities.PedidoEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Hidden
public interface ItensPedidoJpaRepository extends JpaRepository<ItensPedidoEntity, Long> {
    List<ItensPedidoEntity> findAllByPedidoEntity(PedidoEntity pedidoEntity);
}
