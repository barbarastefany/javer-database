<div align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="Spring" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" alt="Maven" width="40" height="40"/>
  <img src="https://i.imgur.com/aN921yZ.png" alt="Lombok" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/mysql/mysql-original.svg" alt="MySQL" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" alt="Docker" width="40" height="40"/>
---
  <h1>Javer Database</h1>
  <p>Um microserviço construído em springboot que persiste dados e realiza operações CRUD de requisições REST recebidas do microserviço <a href="https://github.com/barbarastefany/javer-api">javer-api</a>.</p>
</div>

---
## Tecnologias e Dependências Utilizadas <a id="tecnologias-utilizadas"></a>
- **JDK 22**
- **Spring Boot 3.3.2**
- **Springboot JPA**
- **Springboot WEB**
- **Springboot Test**
- **Maven**
- **Lombok**
- **MySQL Driver**
- **Docker Compose**

---
## Como Executar <a id="como-executar"></a>
> [!IMPORTANT]
> O microserviço [javer-api](https://github.com/barbarastefany/javer-api) permite realizar o cálculo do score de crédito com base no saldo da conta armazenado no banco de dados desta aplicação.
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
## Autoria
[Barbara Carvalho](https://github.com/barbarastefany)

---
## Licença
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
