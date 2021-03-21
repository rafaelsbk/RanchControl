-- Criaçao do banco de dados
use db_RanchControl

-- Criaçao de tabelas
CREATE TABLE Animal (
idAnimal int NOT NULL,
tipoAnimal varchar(70) NOT NULL, -- No sql string é varchar(numero de caracteres) 
nomeAnimal varchar(70),
idadeAnimal int,
pesoAnimal float,
vacina binary,
obsAnimal varchar(255),
mediaPeso float,
PRIMARY KEY (idAnimal));

CREATE TABLE Baias (
idBaia int PRIMARY KEY NOT NULL,
nomeBaia varchar(100) NOT NULL,
capacidade int,
definicao varchar(255),
idFuncionarioResponsavel int);

CREATE TABLE Funcionarios (
idFuncionario int PRIMARY KEY NOT NULL,
nomeFuncionario varchar (100) NOT NULL, 
funcaoFuncionario varchar (70) NOT NULL); 

-- comando select para verificar as tabelas criadas
select * from Baias
select * from Funcionarios 
select * from Animal

-- Alter table para adicionar os pesos dos animais
alter table Animal
add peso1 float, 
	peso2 float, 
	peso3 float,
	peso4 float,
	peso5 float;

-- alter table para colocar a coluna media peso no final da tabela (apenas por capricho)
alter table Animal
DROP COLUMN mediaPeso; -- Exclui a coluna mediaPeso

alter table Animal
add mediaPeso float; -- Criei novamente a mediaPeso, assim ela aparece depois dos pesos no select



