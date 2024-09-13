CREATE TABLE T_NX_PRODUTO (
    id_produto NUMBER(9) PRIMARY KEY,
    tp_produto VARCHAR2(50) NOT NULL,
    nm_produto VARCHAR2(50) NOT NULL,
    nm_marca VARCHAR2(50) NOT NULL,
    nm_modelo VARCHAR2(50) NOT NULL,
    nr_quantidade NUMBER(10,2) NOT NULL,
    vl_produto NUMBER(10,2) NOT NULL,
    ds_produto VARCHAR2(100),
    T_NX_EMPRESA_id_empresa VARCHAR2(10),
    CONSTRAINT T_NX_PRODUTO_T_NX_EMPRESA_FK FOREIGN KEY (T_NX_EMPRESA_id_empresa) REFERENCES T_NX_EMPRESA(id_empresa)
);
