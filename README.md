### Resolvido apenas a fins didático 🚀
Desafio proposto pelo FCamara 🚀

### Status do projeto

Finalizado.

pretendo adicionar algumas das funcionalidades adicionais que faltaram como API de relatorios.

## Tecnologias utilizadas
- Spring Web
- Spring Data JPA
- Spring Boot DevTools
- H2 Database
- Validation

## Como utilizar
### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:

JDK Java 17
intellij IDEA ou Eclipse
Postman/Insomnia

## Rodando o Back-end

### Clone esse repositório na sua Workspace

$ git clone https://github.com/Viniciushfc/desafio-backend-FCamara.git

Importe o projeto para sua IDE

Rode o projeto

## Testando os Endpoint localmente com o Client API
Abra a ferramenta Postman/Insomnia e cole as seguintes URL's:

## API para CRUD de Estabelecimentos:

- GET: http://localhost:8080/establishment
- GET: http://localhost:8080/establishment/{ID}
- GET: http://localhost:8080/establishment/document/{document}
- POST: http://localhost:8080/establishment
- PUT: http://localhost:8080/establishment
- DELET: http://localhost:8080/establishment/{ID}
- DELET: http://localhost:8080/establishment/document/{document}

## API para CRUD de Veículos:

- GET: http://localhost:8080/vehicle
- GET: http://localhost:8080/vehicle/{ID}
- GET: http://localhost:8080/vehicle/plate/{plate}
- POST: http://localhost:8080/vehicle
- PUT: http://localhost:8080/vehicle
- DELET: http://localhost:8080/vehicle/{ID}
- DELET: http://localhost:8080/vehicle/plate/{plate}

## API para CRUD de Controle de Saída/Entrada:

- GET: http://localhost:8080/control
- GET: http://localhost:8080/control/{ID}
- POST: http://localhost:8080/control
- PUT: http://localhost:8080//update/{ID} 
- PUT: http://localhost:8080/control/{ID} (Fecha o controle de saída/entrada)
- DELET: http://localhost:8080/control/{ID}


## Teste para vaga de Desenvolvedor Back-end
Criar uma API REST para gerenciar um estacionamento de carros e motos.

## Cadastro de estabelecimento

Criar um cadastro da empresa com os seguintes campos:
- Nome;
- CNPJ;
- Endereço;
- Telefone;
- Quantidade de vagas para motos;
- Quantidade de vagas para carros.

**Todos** os campos são de preenchimento obrigatório.

## Cadastro de veículos

Criar um cadastro de veículos com os seguintes campos:
- Marca;
- Modelo;
- Cor;
- Placa;
- Tipo.

**Todos** os campos são de preenchimento obrigatório.

## Funcionalidades

   - **Estabelecimento:** CRUD;
   - **Veículos:** CRUD;
   - **Controle de entrada e saída de veículos.**

## Requisitos

   - Modelagem de dados;
   - O retorno deverá ser em formato JSON e XML;
   - Requisições GET, POST, PUT ou DELETE, conforme a melhor prática;
   - A persistência dos dados pode ser realizada da maneira que preferir;
   - Criar README do projeto descrevendo as tecnologias utilizadas, chamadas dos serviços e configurações necessário para executar a aplicação.
   
## Ganha mais pontos
   - Desenvolver utilizando TDD;
   - Criar API de relatório;
   - Sumário da quantidade de entrada e saída;
   - Sumário da quantidade de entrada e saída de veículos por hora;
   - Criar uma solução de autenticação.

## Submissão
Crie um fork do teste para acompanharmos o seu desenvolvimento através dos seus commits.

## Obrigado!
Agradecemos sua participação no teste. Boa sorte! 😄
