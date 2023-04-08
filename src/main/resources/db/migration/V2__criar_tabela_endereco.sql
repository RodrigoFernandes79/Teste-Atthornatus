CREATE TABLE enderecos (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  logradouro VARCHAR(255) NOT NULL,
  cep VARCHAR(8) NOT NULL,
  numero VARCHAR(10),
  cidade VARCHAR(100) NOT NULL,
  endereco_principal VARCHAR(3) NOT NULL,
  pessoa_id BIGINT NOT NULL,
  CONSTRAINT fk_pessoa_endereco FOREIGN KEY (pessoa_id) REFERENCES pessoas(id) ON DELETE CASCADE
);

INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua Teste', '12345678', '123', 'São Paulo', 'SIM', 1);
INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Avenida Teste', '87654321', '456', 'Rio de Janeiro', 'NÃO', 1);

INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua Teste2', '32165498', '362', 'São Paulo', 'SIM', 2);
INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Avenida Teste2', '78945611', '444', 'Recife', 'NÃO', 2);

INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Rua Teste3', '58421657', '192', 'Brasilia', 'SIM', 3);
INSERT INTO enderecos (logradouro, cep, numero, cidade, endereco_principal, pessoa_id) VALUES ('Avenida Teste3', '52136669', '133', 'Recife', 'NÃO', 3);
