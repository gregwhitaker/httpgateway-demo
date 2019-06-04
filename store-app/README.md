# store-app
Application that serves the PDP pages and calls the backend services.

# Running the Application
Run the following command to start the application:

    ./gradlew :store-app:bootRun

## Running the Application in Docker
Run the following command to start the service as a Docker container:

    docker run -e SPRING_PROFILES_ACTIVE='localdocker' -p 8082:8082 netifi/httpgateway-demo-store-app