# Elton Almeida

# Projeto

Controle de cadastro de Profissionais e seus contatos

## Objetivo

Testar os conhecimentos técnicos

## Jar

Copie o arquivo jar para uma pasta de sua preferencia

```bash
Directory: C:\dev\solid\target\solid-0.0.1-SNAPSHOT.jar
```

# API Profissional

```python
# Listar Profisional 
GET
http://host:8080/profissionais?query=NomeTeste&fields=nome

# Retornar Profisional 
GET
http://host:8080/profissionais/{ID}

# Salvar Profissional
POST
http://localhost:8080/profissionais

Body
{
    "nome": "Nome Teste",
    "cargo": "Desenvolvedor",
    "nascimento": "1983-01-26"    
}

# Update Profissional
PUT
http://localhost:8080/profissionais/{ID}

Body
{
    "nome": "Nome Teste",
    "cargo": "Desenvolvedor",
    "nascimento": "1983-01-26"    
}

# Delete Profissional
DELETE
http://localhost:8080/profissionais/{ID}
```

# API Contato

```python
# Listar Contato
GET
http://host:8080/contatos?query=NomeTeste&fields=nome

# Find Contato
GET
http://host:8080/contatos/{ID}

# Salvar Contato
POST
http://localhost:8080/contatos

Body
{
    "nome": "Celular",
    "contato": "11991676621",
    "professional": "1"
}

# Update Contato
PUT
http://localhost:8080/contatos/{ID}

Body
{
    "nome": "Celular",
    "contato": "11991676621",
    "professional": "1"
}

# Delete Contato
DELETE
http://localhost:8080/contatos/{ID}



```
## License

[Eltonsolid Portifolio](https://eltonsolid.com/)