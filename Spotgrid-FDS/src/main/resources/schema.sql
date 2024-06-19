CREATE TABLE aplicativo
(
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(255) NOT NULL,
    custo_mensal DOUBLE NOT NULL
);

CREATE TABLE cliente
(
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome   VARCHAR(255) NOT NULL,
    email  VARCHAR(255) NOT NULL
);

CREATE TABLE usuario
(
    usuario VARCHAR(255) PRIMARY KEY,
    senha   VARCHAR(255) NOT NULL
);

CREATE TABLE assinatura
(
    codigo        BIGINT AUTO_INCREMENT PRIMARY KEY,
    aplicativo_id BIGINT NOT NULL,
    cliente_id    BIGINT NOT NULL,
    FOREIGN KEY (aplicativo_id) REFERENCES aplicativo (codigo),
    FOREIGN KEY (cliente_id) REFERENCES cliente (codigo)
);

CREATE TABLE pagamento
(
    codigo         BIGINT AUTO_INCREMENT PRIMARY KEY,
    assinatura_id  BIGINT NOT NULL,
    data_pagamento DATE   NOT NULL,
    valor DOUBLE NOT NULL,
    FOREIGN KEY (assinatura_id) REFERENCES assinatura (codigo)
);
