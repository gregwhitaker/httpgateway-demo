package demo.inventory.service.error;

public class ProductNotFoundException extends RuntimeException {

    private final String productId;

    public ProductNotFoundException(final String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
