# Api Filmes - Projeto Construído com Spring Boot

## Para iniciar execute o comando abaixo na pasta do projeto 
> ./mvnw spring-boot:run
###### ou importar para IDE da sua preferencia, em seguida executar

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
