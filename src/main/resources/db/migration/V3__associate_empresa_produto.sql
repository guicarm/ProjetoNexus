ALTER TABLE T_NX_PRODUTO
ADD COLUMN empresa_id BIGINT;

ALTER TABLE T_NX_PRODUTO
ADD CONSTRAINT fk_empresa
FOREIGN KEY (empresa_id) REFERENCES T_NX_EMPRESA(id);

INSERT INTO T_NX_EMPRESA (nm_razao_social, nm_fantasia, tp_area_atuacao, nr_cnpj) VALUES
('Grupo Pão de Açúcar S.A.', 'Pão de Açúcar', 'Varejo', '12345678000195'),
('Carrefour Comércio e Indústria Ltda.', 'Carrefour', 'Varejo', '98765432000108'),
('Magazine Luiza S.A.', 'Magalu', 'Varejo', '11122233000181'),
('Itaú Unibanco S.A.', 'Itaú', 'Financeiro', '60700458000155'),
('Banco do Brasil S.A.', 'Banco do Brasil', 'Financeiro', '00000000000191'),
('Ambev S.A.', 'Ambev', 'Bebidas', '07424048000100'),
('Coca-Cola Brasil Ltda.', 'Coca-Cola', 'Bebidas', '00370667000105'),
('O Boticário Franchising S.A.', 'O Boticário', 'Beleza', '01513149000103'),
('Grupo Globo Comunicação e Participações S.A.', 'Grupo Globo', 'Mídia', '33417597000178'),
('Petrobras Distribuidora S.A.', 'Petrobras', 'Petróleo e Gás', '04017317000127');


UPDATE T_NX_PRODUTO SET empresa_id = (SELECT id FROM T_NX_EMPRESA WHERE nm_fantasia = 'Pão de Açúcar') WHERE id IN (1, 2);
UPDATE T_NX_PRODUTO SET empresa_id = (SELECT id FROM T_NX_EMPRESA WHERE nm_fantasia = 'Carrefour') WHERE id IN (3, 4);
