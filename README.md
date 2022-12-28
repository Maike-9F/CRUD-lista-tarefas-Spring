# API Rest de lista de tarefas com Spring boot

## Sobre

Trata-se de um simples serviço Rest de listas de tarefas. Fazendo o uso do banco de dados relacional MySql para a persistência de dados. 

## Tecnologias utilizadas

1. Java 17

2. Spring Boot 3.0.1

3. Maven 4.0.0

4. MySQL

## Explorando funcionalidades

### Criando uma tarefa
```
POST localhost:8080/api/tarefas

{
    "titulo" : "Estudar Orientação a Objetos com Java",
    "descricao" : "Estudar e realizar exercicios com Java aplicando conceitos de OO",
    "concluido" : false 
}

Resposta esperada

HTTP 201 (Created)
Location header: http://localhost:8080/api/tarefas/1

{
    "id": 1,
    "titulo" : "Estudar Orientação a Objetos com Java",
    "descricao" : "Estudar e realizar exercicios com Java aplicando conceitos de OO",
    "dataCriacao": "2022-12-02T01:23:18Z",
    "dataAtualizacao": "2022-12-02T01:23:18Z",
    "concluido" : false,
}
```
### Buscar tarefa por id

```
GET localhost:8080/api/tarefas/{id}

Resposta esperada

HTTP 200 (Ok)

{
    "id": 1,
    "titulo" : "Estudar Orientação a Objetos com Java",
    "descricao" : "Estudar e realizar exercicios com Java aplicando conceitos de OO",
    "dataCriacao": "2022-12-02T01:23:18Z",
    "dataAtualizacao": "2022-12-02T01:23:18Z",
    "concluido" : false, 
}
```

### Buscar todas as tarefas

```
GET localhost:8080/api/tarefas/

Resposta esperada

HTTP 200 (Ok)
[
    {
        "id": 1,
        "titulo" : "Estudar Orientação a Objetos com Java",
        "descricao" : "Estudar e realizar exercicios com Java aplicando conceitos de OO",
        "dataCriacao": "2022-12-02T01:23:18Z",
        "dataAtualizacao": "2022-12-02T01:23:18Z",
        "concluido" : false,
    },
    {
        "id": 2,
        "titulo" : "Criar API com Spring",
        "descricao" : "Fzaer a criação de uma API utilizando Spring Boot",
        "dataCriacao": "2022-12-02T01:25:11Z",
        "dataAtualizacao": "2022-12-02T01:25:11Z",
        "concluido" : false,
    }
]
```

### Atualizar uma tarefa

```
PATCH localhost:8080/api/tarefas/{id}

{
    "titulo" : "Estudar Javascript",
    "descricao" : "Estudar e realizar exercicios com javascript com HTML e CSS",
    "concluido" : true
}

Resposta esperada

HTTP 200 (Ok)

{
    "id": 1,
    "titulo" : "Estudar Javascript",
    "descricao" : "Estudar e realizar exercicios com javascript com HTML e CSS",
    "dataCriacao": "2022-12-02T01:23:18Z",
    "dataAtualizacao": "2022-12-02T02:09:44Z",
    "concluido" : true
}
```

### Excluir uma tarefa

```
DELETE localhost:8080/api/tarefas/{id}

Resposta esperada

HTTP 204 (No Content)
```

### Buscar tarefa por titulo

```
GET localhost:8080/api/tarefas/titulo/{titulo da tarefa}

Resposta esperada

HTTP 200 (Ok)

[lista de tarefas encontradas]
```

### Buscar tarefa pela descrição

```
GET localhost:8080/api/tarefas/descricao/{descricao da tarefa}

Resposta esperada

HTTP 200 (Ok)

[lista de tarefas encontradas]
```
