DROP TABLE IF EXISTS pessoa;

CREATE TABLE pessoa(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(250) NOT NULL,
    idade INT NOT NULL
);

INSERT INTO pessoa(nome, idade) VALUES
    ('Daniel', 27),
    ('Tuxu', 25),
    ('Oliveira', 31),
    ('Fernanda', 29),
    ('Mari', 33)