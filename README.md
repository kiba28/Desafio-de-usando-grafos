# Código resposta do desafio protosto no final no final.

# Calculo de rotas entre cidades.

API que realiza o cadastro de cidades, como sendo o principal dado a distância entre elas, e utilizando grafos calcula a melhor rota, todas a possíveis rotas, ou todas as rotas com um limite de paradadas.

## 🚀 Começando

Para obter uma versão do projeto basta dar um clone neste repósitorio. Para rodar, os passos seguem abaixo.

### 📋 Pré-requisitos

De que coisas você precisa para instalar o software e como instalá-lo?

```
JDK na versão 11 ou superior.
Maven ou
IDE Java - com maven imbutido.
Git - para clonar o repósitorio, porém também é póssivel baixar como zip.
```

### 🔧 Instalação

Por ser uma API monolítica, a instalação consiste em:

Tendo os pre-requisitos instalados, basta seguir os passos abaixo:

```
Importar o projeto para a IDE escolhida.
Fazer o build do projeto para que todas as dependencias sejam baixas.
Execultar o projeto.
```

Com o projeto rodando, pode se testar de pois modos:

```
Utilizando o Postman, ou qualquer programa para realizar requisições.
Utilizando a documentação, acessível atraves do link http://localhost:8080/swagger-ui.html (o link pode mudar caso a url do projeto seja modificada, mas o final sempre será **/swagger-ui.html).
```

## ⚙️ Executando os testes

Os testes foram feitos utilizando modulo do Spring para tests com JUnit Jupiter, todos os testes foram feitos utilizando mocks. Então para executa-los basta estar em um sistema que seja possivel subir o ambiente spring.

### 🔩 Cobertura dos testes

Os testes cobrem a camada de serviços do projeto, e testam todas as funcionalidades lá inseridas.

## 🛠️ Construído com

Mencione as ferramentas que você usou para criar seu projeto

* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Spring Boot](https://spring.io/projects/spring-boot) - Criação e inicialização do projeto.
* [JUnit 5](https://junit.org/junit5/) - Utilizado para realizar os testes.
* [SpringFox](https://springfox.github.io/springfox/) - Criação da documentação, gerando uma documentação com Swagger.
* [Spring Tools 4](https://spring.io/tools) - IDE Utilizada em todas as etapas do projeto.

## ✒️ Autores

* [José Layrton](https://github.com/kiba28) - *Unico desenvolvedor*

--------------------------------------------------------------------------------------------------------------------------------

# Desafio Dev
Bem vindo(a)! Esse desafio tem como objetivo avaliar a capacidade do candidato de construir uma API seguindo as melhores práticas e padrões de desenvolvimento. 

## Cenário
Uma empresa de transporte de carga e pessoal faz algumas rotas de entrega em um grupo de cidades locais. Dada uma simplificação do modelo, todas as rotas entre essas cidades são unidirecionais. Essa empresa deseja portanto conhecer as melhores rotas entre algumas cidades e suas devidas distâncias com o intuito de definir a melhor logística de trabalho. Para isso você foi contratado com o intuito de prover endpoints REST de algumas funcionalidades comuns.

## API
A entrada será dada como um grafo direcionado onde um nó representa uma cidade e uma aresta representa uma rota entre duas cidades. O peso da aresta representa então a distância dessa rota. Uma dada rota jamais aparecerá mais de uma vez, e para uma dada rota, as cidades de origem e destino sempre serão diferentes.
Uma rota direcionada será dada como um objeto JSON, onde as cidades serão nomeadas usando letras do alfabeto [A-Z].
Exemplo: uma rota de A para B com distância 5 é representada como:

```javascript
{​
  "source": "A",
  "target": "B",
  "distance": 5
}​
```
## Funcionalidades Esperadas (Especificação Funcional)
### Salvar Grafo

Esse endpoint deverá receber as arestas de um grafo e salva-las em um banco de dados para consultas posteriores.
* Endpoint: `http://localhost:8080/graph`
* HTTP Method: POST
* HTTP Success Response Code: CREATED (201)
* Contract:
  * Request payload

```javascript
{​
  "data": [
    {​
      "source": "A", "target": "B", "distance": 6
    }​,
    {​
      "source": "A", "target": "E", "distance": 4
    }​,
    {​
      "source": "B", "target": "A", "distance": 6
    }​,
    {​
      "source": "B", "target": "C", "distance": 2
    }​,
    {​
      "source": "B", "target": "D", "distance": 4
    }​,
    {​
      "source": "C", "target": "B", "distance": 3
    }​,
    {​
      "source": "C", "target": "D", "distance": 1
    }​,
    {​
      "source": "C", "target": "E", "distance": 7
    }​,
    {​
      "source": "D", "target": "B", "distance": 8
    }​,
    {​
      "source": "E", "target": "B", "distance": 5
    }​,
    {​
      "source": "E", "target": "D", "distance": 7
    }​
  ]
}​
```
  * Response payload
```javascript
{​
  "id" : 1,
  "data":[
    {​
      "source": "A", "target": "B", "distance":6
    }​,
    {​
      "source": "A", "target": "E", "distance":4
    }​,
    {​
      "source": "B", "target": "A", "distance":6
    }​,
    {​
      "source": "B", "target": "C", "distance":2
    }​,
    {​
      "source": "B", "target": "D", "distance":4
    }​,
    {​
      "source": "C", "target": "B", "distance":3
    }​,
    {​
      "source": "C", "target": "D", "distance":1
    }​,
    {​
      "source": "C", "target": "E", "distance":7
    }​,
    {​
      "source": "D", "target": "B", "distance":8
    }​,
    {​
      "source": "E",  "target": "B", "distance":5
    }​,
    {​
      "source": "E", "target": "D", "distance":7
    }​
  ]
}​
```
### Recuperar Grafo
Esse endpoint deverá retornar um grafo previamente salvo no banco de dados. Se o grafo não existe, deverá retornar HTTP NOT FOUND.
* Endpoint: `http://localhost:8080/graph/<graphId>`
* HTTP Method: GET
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)
* Contract:
  * Request payload: none
  * Response payload

```javascript
{​
  "id" : 1,
  "data":[
    {​
      "source": "A", "target": "B", "distance": 6
    }​,
    {​
      "source": "A", "target": "E", "distance": 4
    }​,
    {​
      "source": "B", "target": "A", "distance": 6
    }​,
    {​
      "source": "B", "target": "C", "distance": 2
    }​,
    {​
      "source": "B", "target": "D", "distance": 4
    }​,
    {​
      "source": "C", "target": "B", "distance": 3
    }​,
    {​
      "source": "C", "target": "D", "distance": 1
    }​,
    {​
      "source": "C", "target": "E", "distance": 7
    }​,
    {​
      "source": "D", "target": "B", "distance": 8
    }​,
    {​
      "source": "E", "target": "B", "distance": 5
    }​,
    {​
      "source": "E", "target": "D", "distance": 7
    }​
  ]
}​
```
### Encontrar todas rotas disponíveis dada uma cidade de origem e outra de destino em um grafo salvo anteriormente
Utilizando um grafo salvo anteriormente, esse endpoint deverá calcular todas as rotas disponíveis de uma cidade origem para outra de destino, dado um número máximo de paradas. Se não existirem rotas possíveis, o resultado deverá ser uma lista vazia. Se o parâmetro "maxStops" não for definido, você deverá listar todas as rotas possíveis. Se o grafo não existir, deverá retornar HTTP NOT FOUND.
Exemplo: No grafo (AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7), as possíveis rotas de A para C com máximo de 3 paradas seriam: ["ABC", "ADC", "AEBC"]
* Endpoint: `http://localhost:8080/routes/<graphId>/from/<town1>/to/<town2>?maxStops=<maxStops>`
* HTTP Method: POST
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)
* Contract:
  * Grafo salvo anteriormente
```javascript
{​
  "data":[
    {​
      "source": "A", "target": "B", "distance": 5
    }​,
    {​
      "source": "B", "target": "C", "distance": 4
    }​,
    {​
      "source": "C", "target": "D", "distance": 8
    }​,
    {​
      "source": "D", "target": "C", "distance": 8
    }​,
    {​
      "source": "D", "target": "E", "distance": 6
    }​,
    {​
      "source": "A", "target": "D", "distance": 5
    }​,
    {​
      "source": "C", "target": "E", "distance": 2
    }​,
    {​
      "source": "E", "target": "B", "distance": 3
    }​,
    {​
      "source": "A", "target": "E", "distance": 7
    }​
  ]
}​
```
  * Request payload: none
  * Response payload
```javascript
{​
  "routes": [
    {​
      "route": "ABC",
      "stops": 2
    }​,
    {​
      "route": "ADC",
      "stops": 2
    }​,
    {​
      "route": "AEBC",
      "stops": 3
    }​
  ]
}​
```
### Determinar a distância mínima entre duas cidades em um grafo salvo

Utilizando um grafo salvo anteriormente, esse endpoint deverá determinar a rota cuja distância seja a mínima possível entre duas cidades. Se as cidades de origem e destino forem iguais, o resultado deverá ser zero. Se não exitir rota possível entre as duas cidades, então o resultado deverá ser -1. Se o grafo não existir, deverá retornar HTTP NOT FOUND.
* Endpoint: `http://localhost:8080/distance/<graphId>/from/<town1>/to/<town2>`
* HTTP Method: POST
* HTTP Success Response Code: OK (200)
* HTTP Error Response Code: NOT FOUND (404)
* Contract:
  * Grafo salvo anteriormente
```javascript
{​
  "data":[
    {​
      "source": "A", "target": "B", "distance":6
    }​,
    {​
      "source": "A", "target": "E", "distance":4
    }​,
    {​
      "source": "B", "target": "A", "distance":6
    }​,
    {​
      "source": "B", "target": "C", "distance":2
    }​,
    {​
      "source": "B", "target": "D", "distance":4
    }​,
    {​
      "source": "C", "target": "B", "distance":3
    }​,
    {​
      "source": "C", "target": "D", "distance":1
    }​,
    {​
      "source": "C", "target": "E", "distance":7
    }​,
    {​
      "source": "D", "target": "B", "distance":8
    }​,
    {​
      "source": "E",  "target": "B", "distance":5
    }​,
    {​
      "source": "E", "target": "D", "distance":7
    }​
  ]
}​
```
  * Request payload: none
  * Response payload
```javascript
{​
  "distance" : 8,
  "path" : ["A", "B", "C"]
}​
```
