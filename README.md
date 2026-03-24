API de Gerenciamento de Departamentos

API REST desenvolvida para gerenciar departamentos organizacionais.

Tecnologias

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database

Estrutura do projeto

* models → entidades JPA
* repositories → acesso ao banco de dados
* services → regras de negócio
* controllers → endpoints REST

Endpoints

* POST /departamentos
* GET /departamentos
* GET /departamentos/{id}
* PUT /departamentos/{id}
* DELETE /departamentos/{id}

Como testar

Os endpoints podem ser testados utilizando:

Postman
ou
Swagger: http://localhost:8080/swagger-ui/index.html
