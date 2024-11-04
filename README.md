<div align="center">
    <h2>⚜️ N E X U S ⚜️</h2>
</div>

<p align="center">
    <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#-funcionalidades">Funcionalidades</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#-diagrama">Diagrama</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#%EF%B8%8F-spring-boot-admin">Spring Admin</a>
</p>

<p align="center"> 
    <a href="https://youtu.be/e6-Bkei8G5M?si=_ofCC3A79gf6vVgP">Vídeo PITCH de apresentação do projeto</a> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="https://youtu.be/Yy-ZdJacnWA">Vídeo de demonstração</a> (Sprint 3)&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="">Vídeo de demonstração</a> (Sprint 4)
</p>

<h3>Integrantes</h3>

- [Matheus O.A.C Silva](https://github.com/mathabes) - RM 98502
- [Amorgan M. Lopes](https://github.com/GanLopes) - RM 98552
- [Guilherme C. de Matos](https://github.com/guicarm) - RM 98874
- [Gustavo G. da Silva](https://github.com/GuGodoi7) - RM 99585
- [Erick K. da Silva](https://github.com/ErickKS) - RM 550371

### Atribuições
- Guilherme: Java, Database, DevOps 
- Amorgan: QA, Database, DevOps
- Erick: Mobile, .NET
- Gustavo: DevOps, Database, .NET
- Matheus: QA, Disruptive Technologies IOT, .NET, Database

--------------------------------------------------
<h3>Como Rodar a Aplicação </h3>

<h4>Pré-requisitos</h4> 

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java11) instalado em seu sistema.
- [Visual Studio Code (VSCode)](https://code.visualstudio.com) instalado em seu sistema.
- [Docker](https://www.docker.com) instalado em seu sistema.

<h4>Passos para Executar a Aplicação</h4> 

- Inicie o Docker Desktop:
```
start "" "C:\Program Files\Docker\Docker\Docker Desktop.exe"
```
`⚠️ O local de instalação do Docker pode variar de acordo com a máquina.`

- Clonar o Repositório:
```bash
git clone https://github.com/guicarm/ProjetoNexus
```

- Abra a pasta do projeto no seu terminal e digite:
```bash
code .
```

- Abra o terminal do VSCode com `Ctrl + "` e rode o arquivo `docker-compose.yml` com o comando:
```bash
docker-compose up -d
```

- Agora com o Visual Studio aberto, rode a aplicação à partir do arquivo ```ProjetoNexusApplication.java```.
--------------------------------------------------

## 📚 Projeto 

<p>Bem-vindo ao Nexus. O projeto consiste no desenvolvimento de um Chatbot funcional que utiliza o WhatsApp como plataforma principal. Esse Chatbot será capaz de se integrar a diversos sistemas externos, como APIs de inteligência artificial, e-commerce, e sistemas de recomendações. Isso permitirá oferecer um atendimento personalizado e eficaz aos clientes e usuários.</p>
<p>O público-alvo do projeto Nexus são empresas que buscam soluções inovadoras para melhorar o atendimento ao cliente, aumentando assim, sua satisfação e consequentemente otimizando suas operações comerciais.</p>

<br/>

## 🖥 Tecnologias

- [Spring](https://spring.io)
- [Docker](https://www.docker.com/)
- [Figma](https://www.figma.com/file/d5rDjubNjdvIn1madq8DZd/Challenge?type=design&node-id=0%3A1&mode=design&t=9i6UZdLvgFCGnHWx-1)
- [Insomnia](https://insomnia.rest/download)
- [Mail Trap](https://mailtrap.io/pt/)

<br/>

## 🧾 Funcionalidades

- [x] Sistema de login/cadastro totalmente funcional (Autentificação com Token JWT).
- [x] Lidar com o tipo de usuário (cliente/funcionário).
- [x] CRUD de usuários.
- [x] CRUD de produtos.
- [x] CRUD de API's.
- [x] CRUD de Empresas.
- [x] CRUD de Chatbots.
      
<br/>

## 📈 Diagrama

<div>
    <img src="./documents/Diagrama de Classes.png" alt="Diagrama de classes" height="400px"/>
</div>

<br/>

## 🌐 [Arquivo JSON Insomnia](./documents/Insomnia_2024-09-15.json) 🌐

<br/>

## 📃 Documentação da API

<h3> Endpoints de documentação </h3>

- [Link para o Banco de dados H2](localhost:8080/db):
```
localhost:8080/db
```

- [Link para a documentação Swagger do projeto](localhost:8080/docs):
```
localhost:8080/docs
```

- [Link para a interface de manutenção do RabbitMQ](localhost:15672):
```
localhost:15672
```
username: `nexus`
<br>
password: `nexus123`

## 🛠️ Spring Boot Admin

- [Link para o Spring Boot Admin](localhost:9090):
```
localhost:9090
```

