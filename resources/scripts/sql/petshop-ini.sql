#-- Script SQL from database "petshop"
#-- SQL no padrão MySQL

#-- Para executar em Postgres, realizar as seguintes modificações:
#-- Remover os comentários MySQL, definido por "#" (sharp);
#-- Alterar as chaves primárias de:
#-- INT AUTO_INCREMENT PRIMARY KEY,
#-- para:
#-- SERIAL PRIMARY KEY,

USE petshop;

CREATE OR REPLACE TABLE clientes (    
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(65) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    rg VARCHAR(20), 
    genero BOOL,
    data_nascimento DATE,
    telefone1 VARCHAR(10),
    telefone2 VARCHAR(10), 
    email VARCHAR(60),
    logradouro VARCHAR(65),
    numero VARCHAR(10),
    bairro VARCHAR(30),
    complemento VARCHAR(60), 
    municipio VARCHAR(60),
    uf VARCHAR(2),
    cep VARCHAR(8)
);
#-- Utilizar true para Feminino e false para Masculino

CREATE OR REPLACE TABLE funcionarios (    
    id_funcionario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(65) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    rg VARCHAR(20), 
    genero BOOL,
    data_nascimento DATE,
    telefone1 VARCHAR(10),
    telefone2 VARCHAR(10), 
    email VARCHAR(60),
    logradouro VARCHAR(65),
    numero VARCHAR(10),
    bairro VARCHAR(30),
    complemento VARCHAR(60), 
    municipio VARCHAR(60),
    uf VARCHAR(2),
    cep VARCHAR(8)
);

CREATE OR REPLACE TABLE produtos (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    marca VARCHAR(30),
    descricao VARCHAR(120),
    valor DOUBLE NOT NULL
);

CREATE OR REPLACE TABLE animais (
	id_animal INT AUTO_INCREMENT PRIMARY KEY,
	id_cliente INT REFERENCES clientes ON DELETE RESTRICT ON UPDATE RESTRICT,
	especie VARCHAR(20) NOT NULL,
	raca VARCHAR(30),
	nome VARCHAR(30),
	genero BOOL, 
	data_nascimento DATE
);
#-- Utilizar true para Feminino e false para Masculino

CREATE OR REPLACE TABLE pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT REFERENCES clientes ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_funcionario INT REFERENCES funcionarios ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_animal INT REFERENCES animais ON DELETE RESTRICT ON UPDATE RESTRICT,
    data_hora TIMESTAMP NOT NULL
);

#-- A tabela abaixo apresenta um exemplo de chave primária (PRIMARY KEY) dupla
#-- com base nas chaves estrangeiras. Isso é possivel pois, uma pedidos não deve repetir
#-- um produto, a repetição seria aplicada através da quantidade de itens do produto.

CREATE OR REPLACE  TABLE itens_pedidos (
    id_pedido INT REFERENCES pedidos ON DELETE RESTRICT ON UPDATE RESTRICT,
    id_produto INT REFERENCES produtos ON DELETE RESTRICT ON UPDATE RESTRICT, 
    quantidade INT NOT NULL,
    valor_venda_produto DOUBLE NOT NULL,
    PRIMARY KEY (id_pedido, id_produto)
);

INSERT INTO clientes
    (nome, cpf, rg, genero, data_nascimento, telefone1, telefone2, email, logradouro, numero, bairro, complemento, municipio, uf, cep)
VALUES 
    ("Adão","11111111111", "111.111", false, "1980/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000"),
    ("Josefina","11111111112", "111.112", true, "1981/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000"),
    ("Monaliza","11111111113", "111.112", true, "1982/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000");

INSERT INTO funcionarios
    (nome, cpf, rg, genero, data_nascimento, telefone1, telefone2, email, logradouro, numero, bairro, complemento, municipio, uf, cep)
VALUES 
    ("Josefina","11111111112", "111.112", true, "1981/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000"),
    ("Monaliza","11111111113", "111.112", true, "1982/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000"),
    ("Adão","11111111111", "111.111", false, "1980/12/25", "69-3333", "69-4444", "adao@gmail.com", "Rua Adelina", "513", "centro", "", "Ji-Paraná", "RO", "76900000");
    
INSERT INTO animais
	(id_cliente, especie, raca, nome, genero, data_nascimento)
VALUES
	(1, "Felino", "Gatarina", "Comum", true, "2020/11/30"),
	(2, "Canino", "Thor", "Boxer", false, "2019/05/15");
	
INSERT INTO produtos
    (nome, marca, descricao, valor)
VALUES
    ("Vacina Cinomose", "Astra Turbo", "Vacina tipo 1", 55.39),
    ("Ração Cachorro Adulto", "WawWaw", "15kg", 125.50),
    ("Ração Gato Adulto", "MotoGato", "3kg", 45.35),
    ("Vermífugo Canino", "Astra Turbo", "Carrapato, sarna, vermes", 35.50),
    ("Vermífugo Felino", "Astra Turbo", "Vermes em geral", 25.25);

INSERT INTO pedidos
    (data_hora, id_cliente, id_funcionario, id_animal)
VALUES 
    (CURRENT_TIMESTAMP(), 1, 1, 1),
    (CURRENT_TIMESTAMP(), 1, 2, 1),
    (CURRENT_TIMESTAMP(), 2, 2, 2);
