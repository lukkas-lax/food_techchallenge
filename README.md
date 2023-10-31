# food_techchallenge
Projeto para curso de pós graduação em Arquitetura de Software na FIAP - Turma 3SOAT

O projeto consiste em criar o backend de uma API de fast food em arquitetura Hexagonal.


# Services
## Salva Usuário
**Endpoint:** */api/food_techchallenge/users*
<br />
**Description:** Método responsável por salvar usuários. 
<br />
**Request Example:** 
<br />
```json
{
    "nome":"Gabriel Freitas",
    "cpf": "222.233.123-19",
    "email": "gf@gmail.com"
}
```
**Response Example:** 
```json
{
    "id": 9,
    "nome": "Gabriel Freitas",
    "cpf": "222.233.123-19",
    "email": "gf@gmail.com"
}
```
