# Microservice-HarryPotter

Atividade do curso Santander Coders | Web Full-Stack da Let's Code.

### Requisitos da atividade:

Desenvolver um Microserviço de cadastro de alunos da escola de mágia de Harry Potter.

- Um endpoint (POST) para o cadastro do aluno:
    -  Consultar um serviço web que informar a qual casa este aluno pertence;
    -  Salvar as informações do aluno juntamente com a chave da casa.
- Um endpoint (GET) passando path param contendo a chave primaria do aluno:
    -  Consultar o endpoint contendo a chave da casa ao qual se deseja ter as informações;
    -  informar todas as informações do aluno além da casa ao qual ele pertence.
   
### Desenvolvimento e Organização do código:

O código é desenvolvido a partir do Spring boot, utilizando o banco de dados H2 e a dependência JPA para manipulação do banco de dados. 
Outras dependências utilizadas no projeto são:

- Swagger: Para a documentação da API;
- Lombok: Remover a verbosidade do código;
   
O código possui um único endpoint ("/alunos") que possui os métods GET e POST. No método POST deve ser passado o nome do aluno e sua série, sendo esta restrita por
um ENUM contendo as opções: PRIMEIRA, SEGUNDA, TERCEIRA e QUARTA. O método GET pode ser passado com path param ou sem, sendo que o path param deve ser a chave da casa 
do aluno. Ao passar a chave, o método retornará as informações do aluno ao qual a chave pertence, já se não passar o path param, o método retornará uma lista com todos
os alunos cadastrados.


### Informações de URL

URL de consultas:
  - Serviço web que informar a qual casa este aluno pertence: https://api-harrypotter.herokuapp.com/sortinghat
  - Sndpoint contendo a chave da casa ao qual se deseja ter as informações: https://api-harrypotter.herokuapp.com/house/{chavecasa}

Swagger: http://localhost:8080/swagger-ui.html

Banco H2: http://localhost:8080/h2-console/
