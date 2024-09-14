CREATE TABLE T_NX_PRODUTO (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tp_produto VARCHAR2(50) NOT NULL,
    nm_produto VARCHAR2(50) NOT NULL,
    nm_marca VARCHAR2(50) NOT NULL,
    nm_modelo VARCHAR2(50) NOT NULL,
    nr_quantidade NUMBER(10,2) NOT NULL,
    vl_produto NUMBER(10,2) NOT NULL,
    ds_produto VARCHAR2(100),
    PRIMARY KEY (id)
);

INSERT INTO T_NX_PRODUTO (tp_produto, nm_produto, nm_marca, nm_modelo, nr_quantidade, vl_produto, ds_produto)
VALUES ('Alimento', 'Arroz', 'Tio João', 'Parboilizado', 50, 4.99, 'Arroz parboilizado 1kg');

INSERT INTO T_NX_PRODUTO (tp_produto, nm_produto, nm_marca, nm_modelo, nr_quantidade, vl_produto, ds_produto)
VALUES ('Bebida', 'Suco de Laranja', 'Del Valle', 'Integral', 100, 5.50, 'Suco de laranja integral 1L');

INSERT INTO T_NX_PRODUTO (tp_produto, nm_produto, nm_marca, nm_modelo, nr_quantidade, vl_produto, ds_produto)
VALUES ('Limpeza', 'Detergente', 'Ypê', 'Neutro', 200, 2.99, 'Detergente líquido neutro 500ml');

INSERT INTO T_NX_PRODUTO (tp_produto, nm_produto, nm_marca, nm_modelo, nr_quantidade, vl_produto, ds_produto)
VALUES ('Higiene', 'Creme Dental', 'Colgate', 'Total 12', 150, 7.49, 'Creme dental proteção total 90g');
