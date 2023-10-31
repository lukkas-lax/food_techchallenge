# Sobre o projeto
O projeto é uma API backend de fast-food, a API conta com todos os métodos necessários para fazer o gerenciamento de fastfood, a documentação conta com o DDD no Miro do projeto, instruções de uso e mapeamento de endpoints. O projeto conta com arquitetura Hexagonal, tecnologia Java, uitilziando Spring, Hibernate, Maven, JDBC entre outros frameworks, MySQL para banco de dados e Docker para conteinerização.

# Passo a passo para inicializar aplicação
1. Clone este repositório.
2. Dentro do repósitorio food_techchallenge, importe o projeto na sua IDE de preferência.
3. Rode os comandos abaixo:
   
- mvn clean install
- docker compose up

# Services
## Salva Usuário
**Endpoint:** */api/food_techchallenge/users*
**Método:** *POST*
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
## Busca Usuário (ID)
**Endpoint:** */api/food_techchallenge/users/${id}*
**Método:** *GET*
<br />
**Description:** Método responsável por buscar usuários pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
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
## Busca Usuário (por CPF)
**Método:** *GET*
**Endpoint:** */api/food_techchallenge/users/cpf/${cpf}*
<br />
**Description:** Método responsável por buscar usuários pelo CPF. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 11,
    "nome": "Gabriel Freitas",
    "cpf": "777.233.123-19",
    "email": "gf@gmail.com"
}
```
## Deleta Usuário (ID)
**Endpoint:** */api/food_techchallenge/users/${id}*
**Método:** *DELETE*
<br />
**Description:** Método responsável por deletar usuários pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```
Usuário 6 deletado com sucesso.
```
## Salva Produto
**Endpoint:** */api/food_techchallenge/produtos*
<br />
**Description:** Método responsável por salvar produtos. 
<br />
**Request Example:** 
<br />
```json
{
    "nome": "X-Salada",
    "descricao": "Hamburguer com alface e tomate",
    "preco": 14.50,
    "categoriaId": 1
}
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "X-Salada",
    "descricao": "Hamburguer com alface e tomate",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Altera Produto
**Endpoint:** */api/food_techchallenge/produtos/${id}*
**Método:** *PUT*
<br />
**Description:** Método responsável por alterar produtos. 
<br />
**Request Example:** 
<br />
```json
{
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.50,
    "categoriaId": 1
}
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Busca Produto (ID)
**Endpoint:** */api/food_techchallenge/produtos/${id}*
**Método:** *GET*
<br />
**Description:** Método responsável por buscar produtos pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Busca Produto (por categoria)
**Endpoint:** */api/food_techchallenge/produtos/categoria/Lanche*
**Método:** *GET*
<br />
**Description:** Método responsável por buscar produtos pela sua categ. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 1,
    "nome": "Lanche Final Editado",
    "descricao": "Teste de edição final",
    "preco": 14.5,
    "categoria": {
        "id": 1,
        "descricao": "Lanche"
    }
}
```
## Deleta Produto (ID)
**Endpoint:** */api/food_techchallenge/produtos/${id}*
**Método:** *DELETE*
**Description:** Método responsável por deletar produto pelo ID do banco de dados. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```
200 ok
```
## Salva Pedido
**Endpoint:** */api/food_techchallenge/pedidos*
**Método:** *POST*
<br />
**Description:** Método responsável por criar produtos. 
<br />
**Request Example:** 
<br />
```json
{
    "userId": 12,
    "produtosIds": [3,3,3]
}
```
**Response Example:** 
```json
{
    "id": 1,
    "user": {
        "id": 12,
        "nome": "Gabriel Freitas",
        "cpf": "777.233.123-19",
        "email": "gf@gmail.com"
    },
    "datapedido": "2023-10-30T23:24:25.7370168",
    "total": 43.5,
    "orderStatus": "RECEIVED"
}
```
## Lista Pedido
**Endpoint:** */api/food_techchallenge/pedidos/status/RECEIVED*
**Método:** *GET*
<br />
**Description:** Método responsável por listar produtos em status espécíficos.
- RECEIVED
- IN_PREPARATION
- READY
- COMPLETED
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
[
    {
        "id": 1,
        "user": {
            "id": 12,
            "nome": "Gabriel Freitas",
            "cpf": "777.233.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2023-10-30T23:24:25.737017",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtos": [
            {
                "id": 3,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoria": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 3,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoria": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 3,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoria": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ]
    }
]
```
## Altera status do pedido
**Endpoint:** */api/food_techchallenge/pedidos/1*
**Método:** *PUT*
<br />
**Description:** Método responsável por avançar status de pedidos espécíficos.

<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
[
    {
        "id": 1,
        "user": {
            "id": 12,
            "nome": "Gabriel Freitas",
            "cpf": "777.233.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2023-{
    "id": 1,
    "user": {
        "id": 12,
        "nome": "Gabriel Freitas",
        "cpf": "777.233.123-19",
        "email": "gf@gmail.com"
    },
    "datapedido": "2023-10-30T23:24:25.737017",
    "total": 43.5,
    "orderStatus": "COMPLETED"
}
```
