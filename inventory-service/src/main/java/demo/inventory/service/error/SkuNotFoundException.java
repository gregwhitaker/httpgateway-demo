package demo.inventory.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the specified SKU cannot be found.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class SkuNotFoundException extends RuntimeException {

    private final String sku;

    public SkuNotFoundException(final String sku) {
        super(String.format("Sku Not Found [sku: %s]", sku));
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }
}
