-- Inserindo Universidade
INSERT INTO universidade (id, nome, sigla, tipo) VALUES 
('550e8400-e29b-41d4-a716-446655440000', 'Universidade Federal de Exemplo', 'UFE', 'Federal');

-- Inserindo Departamentos (sem chefe inicialmente)
INSERT INTO departamento (id, nome, sigla, centro, email_contato, telefone, localizacao, universidade_id) VALUES 
('550e8400-e29b-41d4-a716-446655440001', 'Ciência da Computação', 'CC', 'Centro de Tecnologia', 'cc@ufe.br', '(11) 1234-5678', 'Bloco A', '550e8400-e29b-41d4-a716-446655440000'),
('550e8400-e29b-41d4-a716-446655440002', 'Matemática', 'MAT', 'Centro de Ciências Exatas', 'mat@ufe.br', '(11) 1234-5679', 'Bloco B', '550e8400-e29b-41d4-a716-446655440000');

-- Inserindo Pessoas (base para herança)
INSERT INTO pessoa (id, nome_completo, cpf, email_institucional, telefone) VALUES 
('550e8400-e29b-41d4-a716-446655440010', 'João Silva', '12345678901', 'joao.silva@ufe.br', '(11) 9876-5432'),
('550e8400-e29b-41d4-a716-446655440011', 'Maria Santos', '12345678902', 'maria.santos@ufe.br', '(11) 9876-5433'),
('550e8400-e29b-41d4-a716-446655440012', 'Pedro Oliveira', '12345678903', 'pedro.oliveira@ufe.br', '(11) 9876-5434'),
('550e8400-e29b-41d4-a716-446655440013', 'Ana Costa', '12345678904', 'ana.costa@ufe.br', '(11) 9876-5435'),
('550e8400-e29b-41d4-a716-446655440014', 'Carlos Ferreira', '12345678905', 'carlos.ferreira@ufe.br', '(11) 9876-5436');

-- Inserindo Professores
INSERT INTO professor (id, titulacao, area_atuacao, regime_trabalho, departamento_id) VALUES 
('550e8400-e29b-41d4-a716-446655440010', 'Doutor', 'Algoritmos', 40, '550e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440011', 'Mestre', 'Banco de Dados', 40, '550e8400-e29b-41d4-a716-446655440001');

-- Inserindo Funcionários
INSERT INTO funcionario (id, cargo, tipo_vinculo, departamento_id) VALUES 
('550e8400-e29b-41d4-a716-446655440012', 'Secretário', 'Efetivo', '550e8400-e29b-41d4-a716-446655440001'),
('550e8400-e29b-41d4-a716-446655440013', 'Técnico em Informática', 'Terceirizado', '550e8400-e29b-41d4-a716-446655440002');

-- Inserindo Alunos
INSERT INTO aluno (id, data_nascimento, matricula, professor_id, departamento_id) VALUES 
('550e8400-e29b-41d4-a716-446655440014', '2000-05-15', 202301001, '550e8400-e29b-41d4-a716-446655440010', '550e8400-e29b-41d4-a716-446655440001');

-- Inserindo Carteira de Estudante
INSERT INTO carteira_de_estudante (id, numero, data_emissao, data_validade, aluno_id) VALUES 
('550e8400-e29b-41d4-a716-446655440020', 'CE202301001', '2023-01-15', '2027-01-15', '550e8400-e29b-41d4-a716-446655440014');

-- Relacionamentos Many-to-Many
-- Professor-Funcionário
INSERT INTO professor_funcionario (professor_id, funcionario_id) VALUES 
('550e8400-e29b-41d4-a716-446655440010', '550e8400-e29b-41d4-a716-446655440012'),
('550e8400-e29b-41d4-a716-446655440011', '550e8400-e29b-41d4-a716-446655440013');

-- Aluno-Funcionário
INSERT INTO aluno_funcionario (funcionario_id, aluno_id) VALUES 
('550e8400-e29b-41d4-a716-446655440012', '550e8400-e29b-41d4-a716-446655440014'),
('550e8400-e29b-41d4-a716-446655440013', '550e8400-e29b-41d4-a716-446655440014');

-- Atualizando chefe do departamento
UPDATE departamento SET chefe_departamento_id = '550e8400-e29b-41d4-a716-446655440010' WHERE id = '550e8400-e29b-41d4-a716-446655440001';
UPDATE departamento SET chefe_departamento_id = '550e8400-e29b-41d4-a716-446655440011' WHERE id = '550e8400-e29b-41d4-a716-446655440002';