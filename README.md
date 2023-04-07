# APIRest Cadastro de Pessoa Attornatus
Criando API Teste Atthornatus
##### #querotrabalharnaatthornatus

# Projeto API JSON RESTfull 

 Desafio de uma aplicação de um cadastro de cadastro de pessoas e endereço
 ## Aplicação  em Camadas:
 
 ![AlicacaoCamadas](https://user-images.githubusercontent.com/83513696/139479915-43c64049-3370-4e32-8b83-914fa8ee9111.png)
### Usamos o padrão camadas separando a aplicação backend em três camadas: 
- Controladores Rest (Resource)
- Camada de Serviços (Service)
- Camada de Acesso a dados (Repository)
### Todas as três camadas conversam com as Entidades.

## Tecnologias utilizadas no Projeto:
- Java 17
- Spring Boot
- JPA / Hibernate
- Maven
- H2 Database

## Aplicações  do Projeto:
- Criar uma pessoa;
- Editar uma pessoa;
- Consultar uma pessoa;
- Listar pessoas;
- Criar endereço para pessoa;
- Listar endereços para a pessoa;
- Poder informar qual o endereço é o principal da pessoa;

## Endpoints das APIs no Postman:
#### Criar uma pessoa (POST):
```
http://localhost:8080/pessoas
```
#### Editar uma pessoa (PUT):
```
http://localhost:8080/pessoas/{id}
```
#### Consultar uma pessoa (GET):
```
http://localhost:8080/pessoas/{id}
```
#### Listar pessoas (GET):
```
http://localhost:8080/pessoas
```
#### Criar endereços para uma pessoa (POST):
```
http://localhost:8080/enderecos/{id}
```
#### Criar endereços para uma pessoa (POST):
```
http://localhost:8080/enderecos/pessoas/{id}
```


# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```
bash
# clonar repositório
git clone https://github.com/RodrigoFernandes79/Teste-Atthornatus
```
# executar o projeto
./mvnw spring-boot:run
```
# Autor

Rodrigo Holanda Fernandes
