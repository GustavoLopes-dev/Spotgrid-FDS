CREATE TABLE App
(
    codigo              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome                VARCHAR(255) NOT NULL,
    custoMensal         DOUBLE NOT NULL
);

CREATE TABLE Cliente
(
    codigo              BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome                VARCHAR(255) NOT NULL,
    email               VARCHAR(255) NOT NULL
);

CREATE TABLE Assinatura
(
    codigo              BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoCliente       BIGINT NOT NULL,
    codigoAplicativo    BIGINT NOT NULL,
    inicioVigencia      DATE   NOT NULL,
    fimVigencia         DATE   NOT NULL,
    FOREIGN KEY (codigoCliente) REFERENCES Cliente (codigo),
    FOREIGN KEY (codigoAplicativo) REFERENCES App (codigo)
);

CREATE TABLE Pagamento
(
    codigo              BIGINT AUTO_INCREMENT PRIMARY KEY,
    codigoAssinatura    BIGINT NOT NULL,
    valorPago           DOUBLE NOT NULL,
    dataPagamento       DATE   NOT NULL,
    promocao            VARCHAR(255),
    FOREIGN KEY (codigoAssinatura) REFERENCES Assinatura (codigo)
);

CREATE TABLE Usuario
(
    usuario             VARCHAR(255) PRIMARY KEY,
    senha               VARCHAR(255) NOT NULL
);