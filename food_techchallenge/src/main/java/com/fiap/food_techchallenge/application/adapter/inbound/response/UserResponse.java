 package com.fiap.food_techchallenge.application.adapter.inbound.response;

import com.fiap.food_techchallenge.domain.Produto;
import com.fiap.food_techchallenge.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @NoArgsConstructor
 @Getter
 @Setter
 public class UserResponse {

     private Long id;

     private String nome;

     private String cpf;

     private String email;


     public UserResponse(Long id, String nome, String cpf, String email) {
         this.id = id;
         this.nome = nome;
         this.cpf = cpf;
         this.email = email;
     }
     public static UserResponse fromDomain(User user){
         return new UserResponse(user.getId(), user.getNome(), user.getCpf(), user.getEmail());
     }

 }

