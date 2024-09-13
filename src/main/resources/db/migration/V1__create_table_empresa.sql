CREATE TABLE T_NX_EMPRESA (
    id_empresa NUMBER(9) PRIMARY KEY,
    nm_razao_social varchar(50) NOT NULL,
    nm_fantasia varchar(50),
    tp_area_atuacao varchar(50) NOT NULL,
    nr_cnpj varchar(15) NOT NULL

);