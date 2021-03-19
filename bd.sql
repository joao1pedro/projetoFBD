CREATE TABLE produto(
	cod_prod serial not null,
	nome varchar(50) not null,
	quantidade integer not null,
    custo numeric(5,2) not null,
	valor numeric(5,2) not null,
	CONSTRAINT produto_pkey PRIMARY KEY (cod_prod)
);

CREATE TABLE cliente(
	cod_cliente serial not null,
    cpf varchar(14) not null,
    nome varchar(50) not null,
    sexo char(1) not null,
    data_nascimento varchar(10) not null,
    estado varchar(2) not null,
	cidade varchar(50) not null,
    bairro varchar(50) not null,
    rua varchar(50) not null,
    numero integer not null,
    email varchar(50) not null,
    CONSTRAINT cpf_key PRIMARY KEY (cpf)
);

CREATE TABLE venda(
	idVenda serial not null,
	cpfCliente varchar(14) not null,
	nomeCliente varchar(50) not null,
	qtdItens integer not null,
	subTotal numeric(5,2) not null,
	metodoPgto varchar(30) not null,
	data_hora varchar(19) not null,
	CONSTRAINT idVenda_pkey PRIMARY KEY (idVenda),
	CONSTRAINT cpfCliente_fkey FOREIGN KEY(cpfCliente)
	REFERENCES cliente (cpf)
);

CREATE TABLE itemvenda(
	idItem serial not null,
	idProduto integer not null,
	idVenda integer not null,
	nomeProduto varchar(50) not null,
	qtdItens integer not null,
	valorTotal numeric(5,2) not null,
	CONSTRAINT idItem_pkey PRIMARY KEY (idItem)
);

------------------------------------------------------------
--para usuário do sistema, não foi criado uma interface para a inserção/alteração/atualização dinâmica, logo, operações com o usuário do sistema são feitas a partir do SQL na ferramenta pgadmin4

CREATE TABLE usuario(
	cod_user serial not null,
	username varchar(25) not null,
	userPassword varchar(25) not null,
	userAdmin boolean not null,
	nome varchar (50) not null,
	CONSTRAINT username_pkey PRIMARY KEY (username)
);
ALTER TABLE usuario ALTER COLUMN userAdmin SET DEFAULT FALSE;

-- inserir usuario administrador
INSERT INTO usuario(username, userpassword, useradmin, nome) VALUES('test', 'test1234', TRUE, 'Usuário Teste');

-- inserir usuario comum
INSERT INTO usuario(username, userpassword, nome) VALUES('fulano', 'fulano@123001', 'Fulano da Silva');

------------------------------------------------------------

