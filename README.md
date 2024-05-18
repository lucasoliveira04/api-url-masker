# API de Encurtamento de URLs

Esta API permite encurtar URLs longas para versões mais curtas e gerenciáveis. Desenvolvida em Java com Spring Boot, oferece funcionalidades para encurtar URLs, redirecionar URLs encurtadas de volta para suas originais e gerenciar o armazenamento de URLs encurtadas.

## Como usar

### Requisitos

Certifique-se de ter o JDK (Java Development Kit) e o Maven instalados em seu sistema.

### Executando a API

1. Clone este repositório em sua máquina local:

```bash
git clone https://github.com/lucasoliveira04/api-url-shortner/
```

2. Navegue até o diretório clonado:

```bash
cd api-url-shortner
```

3. Compile o projeto usando o Maven:

```bash
mvn clean install
```

4. Execute a aplicação Spring Boot:

```bash
mvn spring-boot:run
```


### Rotas da API

- **POST /url/shorten:** Para encurtar uma URL, envie um JSON no corpo da solicitação com a seguinte estrutura:

```json
{
  "url": "sua-url-aqui"
}
```

- **GET /url/{codigo}** Para redirecionar para a URL, original, acesse essa rota com o codigo gerado após a barra.

## Exemplo de Uso:


