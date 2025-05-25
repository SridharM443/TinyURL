# TinyURL Backend (Spring Boot + MongoDB)

## Features
- Encode long URLs to short codes
- Decode short URLs back to original
- MongoDB storage
- Docker-ready
- Unit tests with JUnit

## Run

```bash
mvn clean install
java -jar target/tinyurl-0.0.1-SNAPSHOT.jar
```

## Docker

```bash
docker build -t tinyurl .
docker run -p 8080:8080 tinyurl
```

## API Endpoints

- `POST /api/url/encode`
- `GET /api/url/decode?shortUrl=http://tiny.url/xyz123`
