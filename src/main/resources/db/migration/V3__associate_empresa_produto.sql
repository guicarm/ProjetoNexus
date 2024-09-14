ALTER TABLE T_NX_PRODUTO
ADD COLUMN empresa_id BIGINT;

ALTER TABLE T_NX_PRODUTO
ADD CONSTRAINT fk_empresa
FOREIGN KEY (empresa_id) REFERENCES T_NX_EMPRESA(id);

INSERT INTO T_NX_EMPRESA (nm_razao_social, nm_fantasia, tp_area_atuacao, nr_cnpj) VALUES
('Supermercado Pão de Açúcar Ltda', 'Pão de Açúcar', 'Varejo', '12345678000195'),
('Supermercado Carrefour Ltda', 'Carrefour', 'Varejo', '98765432000108');

UPDATE T_NX_PRODUTO SET empresa_id = (SELECT id FROM T_NX_EMPRESA WHERE nm_fantasia = 'Pão de Açúcar') WHERE id IN (1, 2);
UPDATE T_NX_PRODUTO SET empresa_id = (SELECT id FROM T_NX_EMPRESA WHERE nm_fantasia = 'Carrefour') WHERE id IN (3, 4);
