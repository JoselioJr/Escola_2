# Diagrama Entidade-Relacionamento (DER) - Sistema Escola

```mermaid
erDiagram
    UNIVERSIDADE {
        UUID id PK
        string nome
        string sigla
        string tipo
    }
    
    DEPARTAMENTO {
        UUID id PK
        string nome
        string sigla
        string centro
        string emailContato
        string telefone
        string localizacao
        UUID universidade_id FK
        UUID chefe_departamento_id FK
    }
    
    PESSOA {
        UUID id PK
        string nomeCompleto
        string cpf
        string emailInstitucional
        string telefone
    }
    
    PROFESSOR {
        UUID id PK
        string titulacao
        string areaAtuacao
        int regimeTrabalho
        UUID departamento_id FK
    }
    
    FUNCIONARIO {
        UUID id PK
        string cargo
        string tipoVinculo
        UUID departamento_id FK
    }
    
    ALUNO {
        UUID id PK
        string dataNascimento
        int matricula
        UUID professor_id FK
        UUID departamento_id FK
    }
    
    CARTEIRA_DE_ESTUDANTE {
        UUID id PK
        string numero
        string dataEmissao
        string dataValidade
        UUID aluno_id FK
    }
    
    PROFESSOR_FUNCIONARIO {
        UUID professor_id FK
        UUID funcionario_id FK
    }
    
    ALUNO_FUNCIONARIO {
        UUID funcionario_id FK
        UUID aluno_id FK
    }

    %% Relacionamentos
    UNIVERSIDADE ||--o{ DEPARTAMENTO : "possui"
    DEPARTAMENTO ||--o{ PROFESSOR : "tem"
    DEPARTAMENTO ||--o{ FUNCIONARIO : "tem"
    DEPARTAMENTO ||--o{ ALUNO : "matricula"
    PROFESSOR ||--o{ ALUNO : "orienta"
    PROFESSOR ||--o{ DEPARTAMENTO : "chefia"
    ALUNO ||--|| CARTEIRA_DE_ESTUDANTE : "possui"
    
    %% Herança
    PESSOA ||--|| PROFESSOR : "herda"
    PESSOA ||--|| FUNCIONARIO : "herda"
    PESSOA ||--|| ALUNO : "herda"
    
    %% Many-to-Many
    PROFESSOR }|--|| PROFESSOR_FUNCIONARIO : ""
    FUNCIONARIO }|--|| PROFESSOR_FUNCIONARIO : ""
    ALUNO }|--|| ALUNO_FUNCIONARIO : ""
    FUNCIONARIO }|--|| ALUNO_FUNCIONARIO : ""
```

## Relacionamentos Detalhados

### 1:N (Um para Muitos)
- **Universidade → Departamentos**: Uma universidade possui vários departamentos
- **Departamento → Professores**: Um departamento tem vários professores
- **Departamento → Funcionários**: Um departamento tem vários funcionários
- **Departamento → Alunos**: Um departamento matricula vários alunos
- **Professor → Alunos**: Um professor orienta vários alunos

### 1:1 (Um para Um)
- **Aluno ↔ Carteira de Estudante**: Relacionamento bidirecional

### N:N (Muitos para Muitos)
- **Professores ↔ Funcionários**: Através da tabela `professor_funcionario`
- **Alunos ↔ Funcionários**: Através da tabela `aluno_funcionario`

### Herança
- **Pessoa**: Classe base para Professor, Funcionário e Aluno
- Estratégia: `JOINED` (tabelas separadas com chave estrangeira)