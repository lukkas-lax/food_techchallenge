package com.fiap.food_techchallenge.data.repositories;

import com.fiap.food_techchallenge.data.entities.UserEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Hidden
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByCpf(String cpf);
}
