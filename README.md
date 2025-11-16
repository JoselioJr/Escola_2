# Escola_BD

Sistema de gerenciamento escolar com banco de dados implementando os seguintes relacionamentos:

## Relacionamentos Implementados

1. **N Alunos para 1 Professor** - Cada aluno tem um professor orientador
2. **N Professores para 1 Departamento** - Professores pertencem a um departamento
3. **N Funcionários para 1 Departamento** - Funcionários trabalham em um departamento
4. **N Professores para N Funcionários** - Relacionamento many-to-many entre professores e funcionários
5. **N Alunos para N Funcionários** - Relacionamento many-to-many entre alunos e funcionários
6. **N Departamentos para 1 Universidade** - Departamentos pertencem a uma universidade
7. **N Alunos para 1 Departamento** - Alunos estão matriculados em um departamento
8. **1 Carteira para 1 Aluno** - Relacionamento one-to-one bidirecional

## Tecnologias Utilizadas

- Spring Boot 3.x
- Spring Data JPA
- H2 Database (desenvolvimento)
- Maven
- Java 17+

## Estrutura do Projeto

### Entidades

- **Pessoa** (classe base com herança)
  - **Aluno** (herda de Pessoa)
  - **Professor** (herda de Pessoa)
  - **Funcionario** (herda de Pessoa)
- **Universidade**
- **Departamento**
- **CarteiraDeEstudante**

### Endpoints da API

#### Universidades
- `GET /universidades` - Listar todas
- `GET /universidades/{id}` - Buscar por ID
- `POST /universidades` - Criar nova
- `PUT /universidades/{id}` - Atualizar
- `DELETE /universidades/{id}` - Deletar

#### Departamentos
- `GET /departamentos` - Listar todos
- `GET /departamentos/{id}` - Buscar por ID
- `POST /departamentos` - Criar novo
- `PUT /departamentos/{id}` - Atualizar
- `DELETE /departamentos/{id}` - Deletar

#### Professores
- `GET /professores` - Listar todos
- `GET /professores/{id}` - Buscar por ID
- `POST /professores` - Criar novo
- `PUT /professores/{id}` - Atualizar
- `DELETE /professores/{id}` - Deletar

#### Funcionários
- `GET /funcionarios` - Listar todos
- `GET /funcionarios/{id}` - Buscar por ID
- `POST /funcionarios` - Criar novo
- `PUT /funcionarios/{id}` - Atualizar
- `DELETE /funcionarios/{id}` - Deletar

#### Alunos
- `GET /alunos` - Listar todos
- `GET /alunos/{id}` - Buscar por ID
- `POST /alunos` - Criar novo
- `PUT /alunos/{id}` - Atualizar
- `DELETE /alunos/{id}` - Deletar

#### Carteiras de Estudante
- `GET /carteiras` - Listar todas
- `GET /carteiras/{id}` - Buscar por ID
- `POST /carteiras` - Criar nova
- `PUT /carteiras/{id}` - Atualizar
- `DELETE /carteiras/{id}` - Deletar

## Como Executar

1. Clone o repositório
2. Execute: `mvn spring-boot:run`
3. Acesse: `http://localhost:8080`
4. Console H2: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (vazio)

## Dados de Exemplo

O sistema já vem com dados de exemplo que demonstram todos os relacionamentos implementados.