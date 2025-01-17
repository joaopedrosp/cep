CREATE TABLE IF NOT EXISTS TB_CEP_DATA (
    cep VARCHAR(10) NOT NULL,
    logradouro VARCHAR(100),
    complemento VARCHAR(50),
    unidade VARCHAR(10),
    bairro VARCHAR(50),
    localidade VARCHAR(50),
    uf VARCHAR(2),
    estado VARCHAR(50),
    regiao VARCHAR(50),
    ibge VARCHAR(10),
    gia VARCHAR(10),
    ddd VARCHAR(3),
    siafi VARCHAR(10),
    dt_creation DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (cep)
);

INSERT INTO TB_CEP_DATA(cep, logradouro)
VALUES
('99999999', 'DEFAULT CEP')
ON CONFLICT DO NOTHING;

