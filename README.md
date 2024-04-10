<div align="center">
    <p>
        <a href="./README.md">Português</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    </p>
    <h2>⚜️ N E X U S ⚜️</h2>
</div>

<p align="center">
    <a href="#-projeto">Projeto</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#-tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
    <a href="#-funcionalidades">Funcionalidades</a>
</p>

<p align="center"> <a href="https://www.youtube.com">Vídeo PITCH de apresentação do projeto</a> falta o link ainda </p>

<h3>Integrantes</h3>

- Matheus O.A.C Silva - RM 98502
- Amorgan M. Lopes - RM 98552
- Guilherme C. de Matos - RM 98874
- Gustavo G. da Silva - RM 99585
- Erick K. da Silva - RM 550371

--------------------------------------------------
<h3>Como Rodar a Aplicação </h3>

<h4>Pré-requisitos</h4> 

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/#java11) instalado em seu sistema.
- [Visual Studio Code (VSCode)](https://code.visualstudio.com) instalado em seu sistema.

<h4>Passos para Executar a Aplicação</h4> 

- Clonar o Repositório:
```bash
git clone https://github.com/guicarm/ProjetoNexus
```

--------------------------------------------------


<div align="center">
    <img src="./public/readme.gif" alt="project gif" height="400px"/>
</div>

## 📚 Projeto 

<p>Bem-vindo ao Nexus. O projeto consiste no desenvolvimento de um Chatbot funcional que utiliza o WhatsApp como plataforma principal. Esse Chatbot será capaz de se integrar a diversos sistemas externos, como APIs de inteligência artificial, e-commerce, e sistemas de recomendações. Isso permitirá oferecer um atendimento personalizado e eficaz aos clientes e usuários.</p>
<p>O público-alvo do projeto Nexus são empresas que buscam soluções inovadoras para melhorar o atendimento ao cliente, aumentando assim, sua satisfação e consequentemente otimizando suas operações comerciais.</p>

<br/>

## 🖥 Tecnologias

- [Spring](https://spring.io)

<br/>

## 🧾 Funcionalidades

- [x] Sistema de login/cadastro totalmente funcional.
- [x] Lidar com o tipo de usuário (usuário/funcionário).
      
<br/>

## 📈 Diagramas 

<br/>

## 📃 Documentação da API - Usuários

### 💠 Autenticação de Usuário

`POST` /login

Sistema de login de usuário

#### Requisição

```js
{
    email: "user@email.com",
    senha: "senha123",
}
```

#### Resposta - sucesso

```js
{
  id: "123",
  message: "Login bem-sucedido."
}
```

#### Resposta - erro

```js
{
  error: "Credenciais inválidas.",
  message: "Usuário não encontrado. Verifique suas credenciais."
}
```

#### Códigos de Status

| código | descrição               |
| ------ | ----------------------- |
| 200    | Login bem-sucedido.     |
| 401    | Usuário não autorizado. |

<hr/>

### 💠 Registro de Usuário

`POST` /registro

Cadastra um usuário no sistema

#### Requisição

```js
{
    nome: "Usuario da Silva",
    email: "user@email.com",
    senha: "senha123",
}
```

#### Resposta - sucesso

```js
{
    id: "123",
    message: "Usuário cadastrado com sucesso."
}
```

#### Resposta - erro

```js
{
    erro: "Erro ao cadastrar usuário",
    message: "Usuário já existente. Verifique e/ou altere suas credenciais."
}
```

#### Códigos de Status

| código | descrição                                                                    |
| ------ | ---------------------------------------------------------------------------- |
| 201    | Usuário cadastrado com sucesso.                                              |
| 400    | Requisição inválida, dados ausentes, mal formatados ou usuário já existente. |

<hr/>

### 💠 Atualização das Informações do Usuário

`GET` /usuario

Obtém as informações do usuário.

#### Resposta - sucesso

```js
{
    id: "123",
    nome: "Usuario da Silva",
    email: "user@email.com",
    senha: "senha123",
}
```

#### Resposta - erro

```js
{
    error: "Configurações do usuário não encontradas.",
    message: "Não foi possível encontrar as configurações para o usuário especificado."
}
```

#### Códigos de Status

| código | descrição                                  |
| ------ | ------------------------------------------ |
| 200    | Configurações retornadas com sucesso.      |
| 401    | Configurações de usuário não encontradas . |

<br/>

`PUT` /usuario

Altera informações do usuário.

#### Requisição

```js
{
  id: "123",
  nome: "Usuario de Oliveira",
  senha: "novaSenha123"
}

// OU

{
  id_usuario: "123",
  senha: "novaSenha123"
}
```

#### Resposta - sucesso

```js
{
  message: "Configurações do usuário atualizadas com sucesso.";
}
```

#### Resposta - erro

```js
{
  error: "Erro ao atualizar as configurações do usuário.",
  message: "Ocorreu um erro ao processar a atualização das configurações do usuário."
}
```

#### Códigos de Status

| código | descrição                                                              |
| ------ | ---------------------------------------------------------------------- |
| 200    | Configurações do usuário foram atualizadas com sucesso.                |
| 400    | Requisição inválida, como dados de entrada ausentes ou mal formatados. |

<hr/>
