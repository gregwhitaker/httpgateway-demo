# product-service
Service that returns product data for display on a PDP page.

## Running the Service
Run the following command to start the service:

    ./gradlew :product-service:bootRunLocal
    
## Calling the Service
The demo service is initialized with dummy product ids ranging from `001` - `010`.

Run the following curl command to call the service for product `001`:

    curl http://localhost:8081/products/001

If successful, you will receive a response similar to the following:
    
    {
      "productId": "001",
      "shortName": "Widget 1",
      "longName": "Super Awesome Widget - 1",
      "description": "This is a type of widget",
      "active": true,
      "skus": [
        {
          "sku": "001-000",
          "active": true,
          "size": "Small",
          "prices": {
            "list": 10.5,
            "msrp": 11.2,
            "sale": 10.2,
            "formattedList": "10.50",
            "formattedMsrp": "11.20",
            "formattedSale": "10.20"
          }
        },
        {
          "sku": "001-001",
          "active": true,
          "size": "Medium",
          "prices": {
            "list": 11.2,
            "msrp": 11.4,
            "sale": 10.6,
            "formattedList": "11.20",
            "formattedMsrp": "11.40",
            "formattedSale": "10.60"
          }
        },
        {
          "sku": "001-002",
          "active": true,
          "size": "Large",
          "prices": {
            "list": 10.1,
            "msrp": 10.3,
            "sale": 10.1,
            "formattedList": "10.10",
            "formattedMsrp": "10.30",
            "formattedSale": "10.10"
          }
        }
      ]
    }