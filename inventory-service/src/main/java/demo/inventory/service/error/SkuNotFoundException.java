package demo.inventory.service.error;

public class SkuNotFoundException extends RuntimeException {

    private final String sku;

    public SkuNotFoundException(final String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }
}
