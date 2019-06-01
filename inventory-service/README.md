# inventory-service
Service that returns inventory data at both SKU and product levels.

## Running the Service
Run the following command to start the service:

    ./gradlew :inventory-service:bootRun
    
## Calling the Service
The demo service is initialized with dummy product ids ranging from `001` - `010`.

Run the following curl command to call the service for product `001`:

    curl http://localhost:8080/inventory/product/001
    
You should receive a response similar to the following:

    {
      "productId": "001",
      "skus": [
        {
          "sku": "02353",
          "units": 92
        },
        {
          "sku": "03349",
          "units": 29
        },
        {
          "sku": "07626",
          "units": 53
        }
      ]
    }