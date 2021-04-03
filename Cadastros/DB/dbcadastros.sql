-- Comentarios
-- A limha de baixo cria um banco de dados
-- utf8 aceita caracters universais
-- utf8_general_ci mult-linguagem não diferencia letras maiúsculas e minúsculas
create database dbcadastros
default character set utf8
default collate utf8_general_ci;

-- A linha de baixo exclui o banco de dados.
drop database dbcadastros;

-- A linha de baixo seleciona o banco de dados
use dbcadastros;

-- O bloco de instruções abaixo cria uma tabela
-- default charset utf8 define a tabela como o banco de dados
create table tbusuarios (
idusuario int primary key,
nomeusuario varchar(50) not null,
cpfusuario varchar(14) not null unique,
loginusuario  varchar(15) not null unique,
senhausuario varchar(15) not null,
perfilusuario varchar(20) not null
)default charset = utf8;

-- O comando abaixo descreve a tabela
describe tbusuarios;

-- A linha abaixo insere dados na tabela
-- (CRUD) create insert
-- Insere um novo cadastro na tabela
insert into tbusuarios(idusuario, nomeusuario, cpfusuario, loginusuario, senhausuario, perfilusuario)
values
(0, 'Elmar Oliveira de Souza', '03198951658', 'elmar', '1234', 'Administrador'),
(1, 'Jane Maria de Oliveira Souza', '06518939680', 'jane', '12345', 'Gerente'),
(2, 'Lucas Phelim de Oliveira Souza', '48959415820', 'lucas', '123456', 'Vendedor'),
(3, 'Giovana Oliveira Souza', '48959258890', 'giovana', '1234567', 'Cliente'),
(4, 'Giovana Oliveira Souza', '00000000000', 'usuario', '123', 'Cliente');

-- A linha abaixo le e exibe os registro da tabela
-- (CRUD) select
select * from tbusuarios;

-- A linha de baixo modifica ou altera o registro da tabela
-- (CRUD) update
update tbusuarios set cpfusuario='06518939680' where idusuario=2;

-- A linha abaixo le e exibe os registro da tabela
-- (CRUD) select
select * from tbusuarios;

-- A linha abaixo apaga o registro da tabela
-- (CRUD) delete
delete from tbusuarios where idusuario=1;

-- A linha abaixo le e exibe os registro da tabela
-- (CRUD) select
select * from tbusuarios;

-- O bloco de instruções abaixo cria uma tabela
-- default charset utf8 define a tabela como o banco de dados
create table tbclientes (
idcliente int primary key auto_increment,
nomecliente varchar(50) not null,
cepcliente varchar(8),
enderecocliente varchar(100),
numerocliente varchar(5),
bairrocliente varchar(30),
cidadecliente varchar(30),
estadocliente varchar(2) default 'SP',
telefonecliente  varchar(15) not null,
emailcliente varchar(30)
)default charset = utf8;

describe tbclientes;

-- A linha abaixo insere dados na tabela
-- (CRUD) create insert
-- Insere um novo cadastro na tabela
insert into tbclientes(idcliente, nomecliente, cepcliente, enderecocliente,
numerocliente, bairrocliente, cidadecliente, estadocliente, telefonecliente, 
emailcliente)
values
(1, 'Elminto Oliveira de Souza', '13416690', 'Rua Baroneza Dona Rita', '153', 
 'Nova America', 'Piracicaba', 'SP', '19999404142', 'elminto@gmail.com'),
 (2, 'Maria Nilma Oliveira Souza', '39560000', 'Rua Donerio pereira da Silva', '390', 
 'Bairro Raquel', 'Salinas', 'MG', '38999404142', 'maria@gmail.com');
 
 -- A linha abaixo le e exibe os registro da tabela
-- (CRUD) select
select * from tbclientes;

-- O bloco de instruções abaixo cria uma tabela
-- default charset utf8 define a tabela como o banco de dados
-- Decimal contem 10 casas sendo que 2 casas depois da virgula 
-- exe.: 00000000,00
-- primary key chave primaria
-- timestamp default hora autumática do sistema
-- current_timestamp Hora automática do sistema
-- not null o campo não pode ser vazio
-- foreign key pega os dados do campo idcliente da tabela clientes e grava no
-- campo idcliente da tabela ordem_servico 
create table tbordem_servico (
ordemservico int primary key auto_increment,
dataordemservico timestamp default current_timestamp,
equipamento varchar(150) not null,
defeito varchar(150) not null,
servico varchar(150),
tecnico varchar(30),
valor decimal(10,2),
idcliente int not null,
foreign key(idcliente) references tbclientes(idcliente)
)default charset = utf8;

 describe tbordem_servico;
 
 -- A linha abaixo insere dados na tabela
-- (CRUD) create insert
-- Insere um novo cadastro na tabela
insert into tbordem_servico(equipamento, defeito, servico, tecnico, valor, idcliente)
values
('Notebook', 'Não liga', 'Troca de fonte', 'Elmar', 230.20, 1),
('CPU', 'Virus', 'Formatação', 'jane', 80.00, 2);

-- A linha abaixo le e exibe os registro da tabela
-- (CRUD) select
select * from tbordem_servico;

-- A linha de baixo traz informações de duas tabelas
select
OS.ordemservico, equipamento, defeito, servico, valor,
CL.nomecliente, telefonecliente
from tbordem_servico as OS
inner join tbclientes as CL
on (OS.idcliente = CL.idcliente);