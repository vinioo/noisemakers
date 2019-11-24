# Requisitos para inicicalização
- NodeJS
- NPM ou yarn
- Spring boot
- Gradle
- Docker
- Java 8+

# Como inicializar ?
Para inicializar, basta seguir os processos abaixo:

**BACK END**
- Link para o repositório:
https://github.com/vinioo/noisemakers-back
Para realizar o download, basta clicar em clone or download e clicar em download ZIP.

- Iniciar o postgres utilizando o docker (caso possua o postgres instalado basta iniciar o servidor).

docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres

- Colocar os acessos do banco no projeto da API "/resources/application.properties"

- Iniciar o MAIN do projeto java.

**FRONT END**
- Link para o repositório:
https://github.com/vinioo/noisemakers-front
Para realizar o download, basta clicar em clone or download e clicar em download ZIP.

- Entrar na pasta raiz do projeto e digitar "yarn install" ou "npm install".

- Digitar "yarn start" ou "npm start".

**DOCUMENTAÇÃO POSTMAN DA API**
https://documenter.getpostman.com/view/7376719/SW7c3TM8

**VIDEO NO YOUTUBE**
https://www.youtube.com/watch?v=0dqMtz6wUdg

