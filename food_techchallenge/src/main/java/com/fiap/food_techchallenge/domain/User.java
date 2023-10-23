 package com.fiap.food_techchallenge.domain;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.CategoriaEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.ProdutoEntity;
import com.fiap.food_techchallenge.application.adapter.outbound.entity.UserEntity;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private Long id;

    private String nome;

    private String cpf;

    private String email;


    public User(String nome, String cpf, String email) {
    }

    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getNome(),
                userEntity.getCpf(),
                userEntity.getEmail());
    }
}

