package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.PedidoEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Hidden
public interface PedidoJpaRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByOrderStatus(String orderStatus);

    @Query(
            value = "SELECT * FROM food_techchallenge.pedidos where order_status in ('RECEIVED','IN_PREPARATION','READY') order by datapedido DESC;",
            nativeQuery = true)
    List<PedidoEntity>  findAllPedidosAtivos();
}
