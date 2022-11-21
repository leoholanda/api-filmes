# Api Filmes - Projeto Construído com Spring Boot

### Para iniciar execute o comando abaixo na pasta do projeto 
> ./mvnw spring-boot:run
###### ou importar o projeto para IDE da sua preferencia e em seguida executar

### Banco de Dados
##### O Banco de Dados é em memória. Para acessar basta digitar no browser http://localhost:8080/h2-console
##### User Name: sa / Password: sa
#
### Endpoints

##### Consultar Filmes
> GET
/api/filmes/
#
##### Filtro - Consultar filmes por title 
> GET
/api/filmes/titulo/{title}
#
##### Filtro - Consultar filmes por episodio 
> GET
/api/filmes/episodio/{episode_id}
#
##### Adicionar novo filme
>POST
/api/filmes

Ex:
```
{
    "title": "Os Ultimos Jedi",
    "episodeId": 1,
    "director": "Leonardo Holanda"
}
```
