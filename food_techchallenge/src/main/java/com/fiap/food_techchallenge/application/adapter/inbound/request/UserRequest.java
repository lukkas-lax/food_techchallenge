package com.fiap.food_techchallenge.application.adapter.inbound.request;

import com.fiap.food_techchallenge.domain.domains.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String nome;

    private String cpf;

    private String email;

    public User toUserDomain(){
        User user = new User();
        user.setNome(this.nome);
        user.setCpf(this.cpf);
        user.setEmail(this.email);

        return user;
    }

}
