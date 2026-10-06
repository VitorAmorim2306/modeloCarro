# modeloCarro

API REST desenvolvida em Java com Spring Boot para gerenciamento de marcas e modelos de carros, utilizando SQL Server como banco de dados.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- SQL Server
- Maven
- Swagger / OpenAPI
- Lombok

## Estrutura da aplicação

A aplicação possui dois principais recursos:

- Marcas
- Modelos

A persistência dos dados é realizada utilizando Spring Data JPA conectado a um banco de dados SQL Server.

---

## Requisitos

Antes de executar a aplicação, é necessário ter instalado:

- Java
- SQL Server
- Maven (opcional, pois o projeto possui Maven Wrapper)

Também é necessário que o SQL Server esteja em execução.

---

## Configuração do banco de dados

### 1. Criar o banco

No SQL Server Management Studio (SSMS), Azure Data Studio ou outra ferramenta de gerenciamento do SQL Server, execute:

```sql
CREATE DATABASE modelocarro;
```

Depois, verifique se o banco foi criado corretamente.

### 2. Configurar a conexão

No arquivo:

```text
src/main/resources/application.properties
```

configure os dados de acesso ao SQL Server:

```properties
spring.application.name=modelocarro
server.port=8080

springdoc.swagger-ui.path=/
api.version=v1

spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=modelocarro;encrypt=false;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
```

Altere `SUA_SENHA` para a senha do usuário utilizado no SQL Server.

> Observação: não é recomendado publicar senhas reais no GitHub. Antes de disponibilizar o projeto publicamente, substitua a senha por um valor de exemplo ou utilize uma variável de ambiente.

---

## Criação das tabelas

As tabelas do banco são gerenciadas pelo Hibernate através do Spring Data JPA.

Com a propriedade:

```properties
spring.jpa.hibernate.ddl-auto=update
```

as estruturas necessárias para as entidades da aplicação serão criadas ou atualizadas automaticamente no banco de dados.

As principais tabelas utilizadas são:

```text
marcas
modelos
```

---

## Como executar a aplicação

### Windows

Na raiz do projeto, execute:

```bash
mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

A aplicação será executada na porta:

```text
8080
```

---

## Swagger

Após iniciar a aplicação, a documentação da API pode ser acessada em:

```text
http://localhost:8080/swagger-ui/index.html
```

O Swagger permite visualizar e testar os endpoints da API diretamente pelo navegador.

---

# Endpoints da API

## Marcas

### Listar todas as marcas

```http
GET /api/v1/marcas
```

Retorna todas as marcas cadastradas.

### Buscar uma marca por ID

```http
GET /api/v1/marcas/{id}
```

Exemplo:

```http
GET /api/v1/marcas/1
```

### Cadastrar uma marca

```http
POST /api/v1/marcas
```

Exemplo de corpo:

```json
{
  "id": 1,
  "nome": "Toyota",
  "paisOrigem": "Japão",
  "anoFundacao": 1937,
  "siteOficial": "https://www.toyota.com",
  "ativa": true
}
```

### Alterar uma marca

```http
PUT /api/v1/marcas/{id}
```

Exemplo:

```http
PUT /api/v1/marcas/1
```

Corpo:

```json
{
  "id": 1,
  "nome": "Toyota Motors",
  "paisOrigem": "Japão",
  "anoFundacao": 1937,
  "siteOficial": "https://www.toyota.com",
  "ativa": true
}
```

### Excluir uma marca

```http
DELETE /api/v1/marcas/{id}
```

Exemplo:

```http
DELETE /api/v1/marcas/1
```

---

## Modelos

### Listar todos os modelos

```http
GET /api/v1/modelos
```

Retorna todos os modelos cadastrados.

### Buscar um modelo por ID

```http
GET /api/v1/modelos/{id}
```

Exemplo:

```http
GET /api/v1/modelos/1
```

### Cadastrar um modelo

```http
POST /api/v1/modelos
```

Exemplo de corpo:

```json
{
  "id": 1,
  "nome": "Corolla",
  "anoLancamento": 2025,
  "tipoCombustivel": "Hibrido",
  "precoBase": 180000,
  "observacoes": "Modelo utilizado para teste da API"
}
```

### Alterar um modelo

```http
PUT /api/v1/modelos/{id}
```

Exemplo:

```http
PUT /api/v1/modelos/1
```

Corpo:

```json
{
  "id": 1,
  "nome": "Corolla XEi",
  "anoLancamento": 2025,
  "tipoCombustivel": "Hibrido",
  "precoBase": 190000,
  "observacoes": "Modelo atualizado através da API"
}
```

### Excluir um modelo

```http
DELETE /api/v1/modelos/{id}
```

Exemplo:

```http
DELETE /api/v1/modelos/1
```

---

## Operações realizadas pela API

A aplicação permite realizar as principais operações sobre os dados armazenados no SQL Server:

- Consulta de dados
- Inserção de dados
- Alteração de dados
- Exclusão de dados

As operações são realizadas através dos endpoints REST e persistidas utilizando Spring Data JPA.

---

## Teste da conexão com o SQL Server

Para verificar os dados diretamente no banco, podem ser utilizadas consultas como:

```sql
SELECT * FROM marcas;
```

e:

```sql
SELECT * FROM modelos;
```

Também é possível utilizar essas consultas para verificar se os dados enviados pelos endpoints da API foram realmente gravados, alterados ou excluídos no SQL Server.

---

## Fluxo da aplicação

```text
Cliente / Swagger
        |
        v
   API REST
        |
        v
   Controller
        |
        v
Spring Data JPA
        |
        v
   Repository
        |
        v
    SQL Server
```

---

## Objetivo do projeto

Este projeto foi desenvolvido como parte da disciplina de Microservices and Web Engineering, utilizando Java e Spring Boot para criação de uma API REST com persistência de dados em SQL Server.

O projeto demonstra a criação de endpoints para gerenciamento de marcas e modelos de carros, além da integração entre a API, Spring Data JPA e o banco de dados SQL Server.