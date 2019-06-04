# inventory-service
Service that returns inventory data at both SKU and product levels.

## Running the Service
Run the following command to start the service:

    ./gradlew :inventory-service:bootRunLocal
    
## Running the Service in Docker
Run the following command to start the service as a Docker container:

    docker run -e SPRING_PROFILES_ACTIVE='localdocker' -p 8080:8080 netifi/httpgateway-demo-inventory-service
    
## Calling the Service
The demo service is initialized with dummy product ids ranging from `001` - `010`.

Run the following curl command to call the service for product `001`:

    curl http://localhost:8080/inventory/products/001
    
If successful, you will receive a response similar to the following:
    
    {
      "productId": "001",
      "skus": [
        {
          "sku": "001-000",
          "units": 5
        },
        {
          "sku": "001-001",
          "units": 18
        },
        {
          "sku": "001-002",
          "units": 73
        }
      ]
    }

To retrieve the inventory for a single SKU you would run the following curl command:

    http://localhost:8080/inventory/skus/001-002
    
If successful, you would receive a response similar to the following:

    {
      "sku": "001-002",
      "units": 92
    }