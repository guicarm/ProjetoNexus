CREATE TABLE T_NX_USUARIO (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),       
    email VARCHAR(255),     
    senha VARCHAR(255),    
    tipo VARCHAR(50),        
    PRIMARY KEY (id)       
);

INSERT INTO T_NX_USUARIO (nome, email, senha, tipo) 
VALUES 
('Amorgan', 'gansado@gmail.com', '$2a$10$hLe0htwGW66VaMk8jCp7xewxi2SKUof4shulI9K9Wxat1Z65nPcgO', 'cliente'),

('Gustavo', 'godoi@gmail.com', '$2a$10$T1vtGIM6ghj0gq2DaPuAb.igUqQKsAZRnD4apV.uqzExD5jLZfwjK', 'cliente'),

('Erick', 'erick@gmail.com', '$2a$10$z0cqcgahC/LNhr65D3Zmg.scw.X.BSkDQBAnJSIP9unQe.IZW718.', 'cliente');
