CREATE TABLE pessoas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_de_nascimento DATE NOT NULL
);

INSERT INTO pessoas (nome, data_de_nascimento) VALUES
('João', '1990-01-01'),
('Maria', '1985-06-30'),
('Pedro', '2000-12-15')

