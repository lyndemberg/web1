CREATE TABLE departamento(
	id SERIAL,
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY(id)
);

CREATE SEQUENCE matricula_sequence START 1001;

CREATE TABLE funcionario(
	matricula INT DEFAULT NEXTVAL('matricula_sequence'),
	nome VARCHAR(100),
	foto BYTEA NOT NULL,
	email VARCHAR(100) UNIQUE,
	telefone1 VARCHAR(11),
	telefone2 VARCHAR(11),
	departamento_id INT,
	FOREIGN KEY(departamento_id) REFERENCES departamento(id) ON DELETE SET NULL ON UPDATE CASCADE,
	PRIMARY KEY(matricula)
);

CREATE TABLE projeto(
	codigo SERIAL,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT NOT NULL,
	concluido BOOLEAN NOT NULL,	
	PRIMARY KEY(codigo)
);

CREATE TABLE alocacao(
	codigo_projeto INT NOT NULL,
	matricula_funcionario INT NOT NULL,
	FOREIGN KEY(codigo_projeto) REFERENCES projeto(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(matricula_funcionario) REFERENCES funcionario(matricula) ON DELETE CASCADE ON UPDATE CASCADE,
	PRIMARY KEY(codigo_projeto,matricula_funcionario)
);




