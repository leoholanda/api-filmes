# api-filmes

### endpoints

##### Consulta Filmes
> GET
/api/filmes/
#
##### Filtro - Consulta filmes por title 
> GET
/api/filmes/titulo/{title}
#
##### Filtro - Consulta filmes por episodio 
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
