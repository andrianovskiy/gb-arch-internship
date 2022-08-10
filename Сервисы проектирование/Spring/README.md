### Ручная выкладка

    docker build -t daniakacta/arch-intern:latest .
    docker push index.docker.io/daniakacta/arch-intern:latest

### Поднять локально

    docker pull daniakacta/arch-intern
    docker run -d -t --name arch-intern -p 8090:8080 --restart=always daniakacta/arch-intern
    docker stop arch-intern
    docker rm arch-intern

### Swagger UI
    http://localhost:8080/swagger-ui.html
    http://localhost:8080/api-docs/
    http://localhost:8080/api-docs.yaml