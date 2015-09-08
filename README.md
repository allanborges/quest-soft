## Descricao

Aplicação foi feita de forma extremamente básica, devido a falta de tempo.

O DER da aplição pode ser visto no arquivo der_quest-app.png

## Tecnologia Usadas

Fugindo um pouco da mesmice (JSF+PRIMEFACES) , foi usado: 

- VRaptor 4.
- CDI
- JPA

O Container Web usado foi o TomCat 7, o SGBD usado foi o MYSQL 5


## Instruções de Build/Instalação e uso

- Rodar o script carga_tabelas.sql

- Importar o projeto pelo MAVEN no eclipse usando a opção "import -> existing Maven Project" baixar as dependências dando um "Maven -> Update Project".

- modificar o arquivo Persistence.xml com suas devidas configurações (você deve criar um Banco,usuario,senha),

- Fazer o deploy para o TomCat 7.
 
- Acessar à aplicação usando http://seuEndereço:portaConfigurada/quest-app/


## Autor

Allan Borges


