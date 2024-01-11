 package com.fiap.food_techchallenge.data.response;


import com.fiap.food_techchallenge.domain.models.UserModel;
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
     public static UserResponse fromDomain(UserModel userModel){
         return new UserResponse(userModel.getId(), userModel.getNome(), userModel.getCpf(), userModel.getEmail());
     }

 }

