 package com.fiap.food_techchallenge.domain.domains;

import com.fiap.food_techchallenge.application.adapter.outbound.entity.UserEntity;
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
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public User(Long userId) {
        this.id = userId;
    }

    public static User fromEntity(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getNome(),
                userEntity.getCpf(),
                userEntity.getEmail());
    }
}

