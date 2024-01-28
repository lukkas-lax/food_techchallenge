# Food Tech Challenge - Fase 1
## Sobre o projeto
O projeto é uma API backend de fast-food, a API conta com todos os métodos necessários para fazer o gerenciamento de fastfood, a documentação conta com o DDD no Miro do projeto, instruções de uso e mapeamento de endpoints. O projeto conta com arquitetura Clean Architecture, tecnologia Java, utilizando Spring, Hibernate, Maven, JDBC entre outros frameworks, MySQL para banco de dados e Kubernetes junto com Docker para conteinerização e provisionamento da aplicação.

## Desenho da arquitetura
![Diagrama sem nome drawio](https://github.com/lukkas-lax/food_techchallenge/assets/77997696/8246d4d6-59fd-47fd-b621-719a73e83282)


## Pré-Requisitos
1. Java 21
2. Maven 4.0.0
3. Kubectl
4. Docker
5. Docker Desktop ou Minikube (interface)

## Validação dos Pré-Requisitos
Para validar se todos os pré-requisitos estão devidamente instalados, rode os comandos abaixos:
1. Java = "java --version"
2. Maven = "mvn -v"
3. Kubectl = "kubectl version --output=yaml"
4. Docker = "docker -v"
5. Docker Desktop ou Minikube = "kubectl get pods"

## Passo a passo para inicializar aplicação
1. Clone este repositório.
2. Dentro do repósitorio food_techchallenge, importe o projeto na sua IDE de preferência.
3. Rode os comandos abaixo:
   
- mvn clean install
- kubectl apply -f food_techchallenge-svc.yaml
- kubectl apply -f food_techchallenge-hpa.yaml
- kubectl apply -f food_techchallenge-deployment.yaml
- kubectl port-forward service/food-techchallenge-svc 8080:8080

Após a execução dos comandos com sucesso é possível realizar todas as operações abaixo dentro do Postman em relação a pedidos, produtos e clientes.

## Collection do Postman
[Collection](https://github.com/lukkas-lax/food_techchallenge/blob/master/Tech%20Challenge%20Final.postman_collection.json)

## Swagger
http://localhost:8080/swagger-ui/index.html

## Script do banco de dados
[Script](https://github.com/lukkas-lax/food_techchallenge/blob/master/food_techchallenge/database_creation.sql)


# Services
## Salva Usuário
**Endpoint:** */api/food_techchallenge/users*<br />
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
**Endpoint:** */api/food_techchallenge/users/${id}*<br />
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
**Endpoint:** */api/food_techchallenge/users/cpf/${cpf}*<br />
**Método:** *GET*
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
**Endpoint:** */api/food_techchallenge/users/${id}*<br />
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
**Endpoint:** */api/food_techchallenge/produtos*<br />
**Método:** *POST*
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
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
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
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
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
**Endpoint:** */api/food_techchallenge/produtos/categoria/Lanche*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por buscar produtos pela sua categoria, sendo elas: Lanche; Acompanhamento; Bebida; Sobremesa.
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
**Endpoint:** */api/food_techchallenge/produtos/${id}*<br />
**Método:** *DELETE* <br />
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
**Endpoint:** */api/food_techchallenge/pedidos*<br />
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
## Lista Pedido (Por Status)
**Endpoint:** */api/food_techchallenge/pedidos/status/RECEIVED*<br />
**Método:** *GET*
<br />
**Description:** Método responsável por listar produtos em determinados status, sendo eles: RECEIVED; IN_PREPARATION; READY; COMPLETED. 
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
        "id": 2,
        "user": {
            "id": 12,
            "nome": "Gabriel Freitas",
            "cpf": "777.233.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2023-10-31T20:37:28.923042",
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
## Altera Status Pedido (ID)
**Endpoint:** */api/food_techchallenge/pedidos/${id}*<br />
**Método:** *PUT*<br />
**Description:** Método responsável por avançar o status do pedido desejado, sendo eles: RECEIVED; IN_PREPARATION; READY; COMPLETED. 
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
## Busca Status de Pagamento do Pedido (ID)
**Endpoint:** */api/food_techchallenge/pedidos/payment-status/${id}*<br />
**Método:** *GET*<br />
**Description:** Método responsável por buscar um pedido e seu status de pagamento. 
<br />
**Request Example:** 
<br />
```
Path parameter
```
**Response Example:** 
```json
{
    "id": 13,
    "uuid": "7c0df407-9ca1-41b2-8c54-d411cd6db4f6",
    "userModel": {
        "id": 6,
        "nome": "3213",
        "cpf": "656456",
        "email": "sdd@gmail.com"
    },
    "datapedido": "2024-01-25T21:53:04.335955",
    "total": 43.5,
    "orderStatus": "RECEIVED",
    "produtoModels": [
        {
            "id": 1,
            "nome": "X-Salada",
            "descricao": "Hamburguer com alface e tomate",
            "preco": 14.5,
            "categoriaModel": {
                "id": 1,
                "descricao": ""
            }
        },
        {
            "id": 1,
            "nome": "X-Salada",
            "descricao": "Hamburguer com alface e tomate",
            "preco": 14.5,
            "categoriaModel": {
                "id": 1,
                "descricao": ""
            }
        },
        {
            "id": 1,
            "nome": "X-Salada",
            "descricao": "Hamburguer com alface e tomate",
            "preco": 14.5,
            "categoriaModel": {
                "id": 1,
                "descricao": ""
            }
        }
    ],
    "paymentStatus": "APROVADO"
}
```
## Busca Status de Pagamento do Pedido (ID)
**Endpoint:** */api/food_techchallenge/pedidos*<br />
**Método:** *GET*<br />
**Description:** Método responsável por buscar e ordenar pedidos.
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
        "id": 4,
        "uuid": "",
        "userModel": {
            "id": 4,
            "nome": "Guil 424",
            "cpf": "737.236.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-08T18:47:44.788546",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 2,
                "nome": "X-teste",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 5,
        "uuid": "",
        "userModel": {
            "id": 4,
            "nome": "Guil 424",
            "cpf": "737.236.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-08T18:47:51.147427",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 2,
                "nome": "X-teste",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 6,
        "uuid": "",
        "userModel": {
            "id": 4,
            "nome": "Guil 424",
            "cpf": "737.236.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-10T16:03:42.298385",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 2,
                "nome": "X-teste",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 7,
        "uuid": "e71bda40-5969-43ac-86c7-6d3ca68c96f3",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:15:09.526289",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 8,
        "uuid": "37fd528e-9ffd-4872-9250-4291c7b5b2cb",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:16:32.871813",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 9,
        "uuid": "a8e88b1b-cb24-4604-b680-5d8c7764808c",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:17:16.138856",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 10,
        "uuid": "a9d0cb6b-a569-4b85-87e3-2f5a453ee89e",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:17:56.565097",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 11,
        "uuid": "0bcba440-73ae-46d9-8f91-9142f87c4a11",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:22:06.263812",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 12,
        "uuid": "26802a84-c963-4bb8-8aef-2ffff2d0e9b5",
        "userModel": {
            "id": 5,
            "nome": "Clebinho",
            "cpf": "232321",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-20T19:22:36.231194",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 13,
        "uuid": "7c0df407-9ca1-41b2-8c54-d411cd6db4f6",
        "userModel": {
            "id": 6,
            "nome": "3213",
            "cpf": "656456",
            "email": "sdd@gmail.com"
        },
        "datapedido": "2024-01-25T21:53:04.335955",
        "total": 43.5,
        "orderStatus": "RECEIVED",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 3,
        "uuid": "",
        "userModel": {
            "id": 4,
            "nome": "Guil 424",
            "cpf": "737.236.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-08T17:53:23.212565",
        "total": 43.5,
        "orderStatus": "IN_PREPARATION",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    },
    {
        "id": 1,
        "uuid": "",
        "userModel": {
            "id": 1,
            "nome": "Gabriel Freitas",
            "cpf": "777.233.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-08T17:09:25.986173",
        "total": 14.5,
        "orderStatus": "READY",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": null
    },
    {
        "id": 2,
        "uuid": "",
        "userModel": {
            "id": 3,
            "nome": "Guil Freitas",
            "cpf": "737.233.123-19",
            "email": "gf@gmail.com"
        },
        "datapedido": "2024-01-08T17:30:00.439687",
        "total": 29.0,
        "orderStatus": "READY",
        "produtoModels": [
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            },
            {
                "id": 1,
                "nome": "X-Salada",
                "descricao": "Hamburguer com alface e tomate",
                "preco": 14.5,
                "categoriaModel": {
                    "id": 1,
                    "descricao": ""
                }
            }
        ],
        "paymentStatus": "APROVADO"
    }
]
```
