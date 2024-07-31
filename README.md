<div align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="Spring" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg" alt="MySQL" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" alt="Docker" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" alt="Maven" width="40" height="40"/>
  <br>
  <h1>Banco de dados Javer</h1>
  <p>Um microserviço construído em springboot que persiste dados e realiza operações CRUD de requisições REST recebidas do microserviço <a href="https://github.com/barbarastefany/javer-api">javer-api</a>.</p>
</div>

---
## Índice
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Dependências](#dependências)
- [Como Executar](#como-executar)
- [Documentação da API](#documentação-da-api)
- [Autores](#autores)
- [Licença](#licença)

---
## Tecnologias Utilizadas <a id="tecnologias-utilizadas"></a>
- **JDK 22**
- **Spring Boot 3.3.2**
- **Maven**
- **Docker**

---
## Dependências <a id="dependências"></a>
- **Springboot JPA**
- **Springboot WEB**
- **Springboot Test**
- **MySQL Driver**
- **Docker Compose**
- **Lombok**
  
---
## Como Executar <a id="como-executar"></a>
> [!IMPORTANT] 
> Utilize o microserviço [javer-api](https://github.com/barbarastefany/javer-api) para realizar requisições REST.
## Instruções de execução:
1. Clone o repositório:
```
git clone https://github.com/barbarastefany/javer-database
```
2. Importe a aplicação para a sua IDE
3. Execute a classe main:
```
JaverDatabaseApplication
```
4. Realize as requisições por meio da aplicação [javer-api](https://github.com/barbarastefany/javer-api).

---
## Documentação da API
A documentação da API está disponível através do Swagger UI em:
```
http://localhost:8080/swagger-ui/index.html
```
---
## Autores
[Barbara Carvalho](https://github.com/barbarastefany)

---
## Licença
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
