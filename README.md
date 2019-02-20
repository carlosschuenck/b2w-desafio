# Guia de inicialização da API.
```
Pré-requisitos:
1 - MondoDB instalado e configurado na porta: 27017 e host: localhost
2 - Maven versão 3.5.4 ou superior
```
```
Passo a passo:
1 - Inicialize o MongoDB com o comando: mongod --port 27017
2 - Descompate o zip do projeto e navegue até o diretório onde se encontra o arquivo pom.xml
3 - Abra o cmd neste diretório e execute o comando mvn install.
5 - Após a conclusão, execute o comando mvn spring-boot:run
6 - Abra o browser e acesse a documentação da API através do link: http://localhost:8686/b2w-api/swagger-ui.html
```
