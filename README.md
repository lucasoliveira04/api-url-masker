## Como usar

### Rotas da API

- **POST /url/shorten:** Para encurtar uma URL, envie um JSON no corpo da solicitação com a seguinte estrutura:

```json
{
  "url": "sua-url-aqui"
}
```

- **GET /url/{codigo}** Para redirecionar para a URL original, acesse essa rota com o código gerado após a barra.

