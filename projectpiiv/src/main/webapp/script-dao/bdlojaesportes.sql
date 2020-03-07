CREATE DATABASE loja_esporte;

USE loja_esporte;

CREATE TABLE produto(
id_produto INT(11) AUTO_INCREMENT NOT NULL,
Nome VARCHAR(30) NOT NULL,
descricao TEXT,
tipo_produto VARCHAR(20) NOT NULL,
qtd_estoque DOUBLE NOT NULL DEFAULT 0,
preco DOUBLE NOT NULL,
PRIMARY KEY (id_produto)
);

CREATE TABLE imagem_produto(
id int(11) AUTO_INCREMENT NOT NULL,
id_produto INT(11) NOT NULL,
caminho_imagem VARCHAR(200),
PRIMARY KEY (id),
FOREIGN KEY (id_produto) REFERENCES produto(id_produto) ON DELETE CASCADE
);


drop database loja_esporte



