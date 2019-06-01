package demo.product.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when the specified product cannot be found.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    private final String productId;

    public ProductNotFoundException(final String productId) {
        super(String.format("Product Not Found [productId: %s]", productId));
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
