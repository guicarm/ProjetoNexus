INSERT INTO T_NX_EMPRESA (id_empresa, nm_razao_social, nm_fantasia, tp_area_atuacao, nr_cnpj) VALUES
(1, 'RodRaf', 'RodRaf', 'Atacado', '12345678901234'),
(2, 'Frigoyama', 'Frigoyama', 'Varejo', '98765432109876');


INSERT INTO T_NX_PRODUTO (id_produto, tp_produto, nm_produto, nm_marca, nm_modelo, nr_quantidade, vl_produto, ds_produto, T_NX_EMPRESA_id_empresa) VALUES
(1, 'Refrigerante', 'Coca-Cola', 'Coca-Cola', '2L', 50, 10, 'Refrigerante Coca-Cola de 2L', 1),
(2, 'Suco', 'DellVale Laranja', 'Dell Vale', '1,5L', 100, 15, 'Suco Dell Vale de laranja 1,5L', 2);


UPDATE T_NX_PRODUTO 
SET T_NX_EMPRESA_id_empresa = (SELECT id_empresa FROM T_NX_EMPRESA WHERE nm_razao_social = 'RodRaf') 
WHERE id_produto = 1;

UPDATE T_NX_PRODUTO 
SET T_NX_EMPRESA_id_empresa = (SELECT id_empresa FROM T_NX_EMPRESA WHERE nm_razao_social = 'Frigoyama') 
WHERE id_produto = 2;